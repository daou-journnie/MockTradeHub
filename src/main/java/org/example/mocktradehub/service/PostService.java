package org.example.mocktradehub.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.DAO.PostDAO;
import org.example.mocktradehub.DAO.StockDAO;
import org.example.mocktradehub.model.Order;
import org.example.mocktradehub.model.Post;
import org.example.mocktradehub.util.MyBatisSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostService {
    private PostDAO postDAO;
    private StockDAO stockDAO;
    private MemberService memberService = new MemberService();



    public PostService() {
        SqlSessionFactory factory = MyBatisSessionFactory.getSqlSessionFactory();
        this.postDAO = new PostDAO(factory);
        this.stockDAO = new StockDAO(factory);
    }

    // 포스트 작성 처리: 성공 시 true 반환
    public boolean createPost(Post post) {
        int result = postDAO.insertPost(post);
        return result > 0;
    }

    public boolean createOrderPost(Order order) {
        Post post = new Post();
        String stockName = stockDAO.getStockNameByCode(order.getStockCode());
        // 주문 정보를 기반으로 포스트 내용을 생성
        String orderTypeKorean = order.getOrderType().equalsIgnoreCase("BUY") ? "구매" : "판매";

        String postContent = String.format("{%s} {%d}주 {%s}\n1주당 {%s}원",
                stockName,
                order.getOrderTotalQuantity(),
                orderTypeKorean,
                order.getOrderPrice());

        post.setPostContent(postContent);
        post.setMemberId(order.getRoomMemberId());
        post.setRoomId(order.getRoomID());
        int result = postDAO.insertPost(post);
        return result > 0;
    }


    // 특정 방의 포스트 리스트 조회
    public List<Post> getPostsByRoomId(int roomId) {
        List<Post> posts = postDAO.getPostsByRoomId(roomId);
        Map<String, Post> postMap = new HashMap<>();
        List<Post> rootPosts = new ArrayList<>();
        for(Post post : posts) {
            String memberNickname = memberService.getMemberById(post.getMemberId()).getMemberNickname();
            post.setMemberNickname(memberNickname);
            postMap.put(String.valueOf(post.getPostId()), post);
        }

        for (Post post : posts) {
            if (post.getPostParentId() == null) {
                rootPosts.add(post);
            } else {
                Post parentPost = postMap.get(String.valueOf(post.getPostParentId()));
                if (parentPost != null) {
                    parentPost.getComments().add(post);
                }
            }
        }
        return rootPosts;
    }
}
