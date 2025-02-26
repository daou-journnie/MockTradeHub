package org.example.mocktradehub.DAO;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.mocktradehub.model.Room;

public class RoomDAO {
    private SqlSessionFactory sqlSessionFactory;

    public RoomDAO(SqlSessionFactory factory) {
        this.sqlSessionFactory = factory;
    }

    // 방 생성
    public int insertRoom(Room room) {
        SqlSession session = sqlSessionFactory.openSession();
        int new_room_id = 0;
        try {
            new_room_id = session.insert("RoomMapper.insertRoom", room);
            session.commit();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new_room_id;
    }
}
