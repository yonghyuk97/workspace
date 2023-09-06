package edu.kh.project.chatting.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.project.chatting.model.DTO.ChattingRoom;
import edu.kh.project.chatting.model.DTO.Message;
import edu.kh.project.member.model.dto.Member;

public interface ChattingService {
    
	
    /** 채팅에 뿌려질 채팅방리스트 가져오기
     * @param memberNo
     * @return list
     */
    List<ChattingRoom> selectRoomList(int memberNo);

    int checkChattingNo(Map<String, Integer> map);

    int createChattingRoom(Map<String, Integer> map);


    int insertMessage(Message msg);

    int updateReadFlag(Map<String, Object> paramMap);

    List<Message> selectMessageList( Map<String, Object> paramMap);

   /** 채팅 상대 검색
    * @param map 
    * @return memberList
    */
   List<Member> selectTarget(Map<String, Object> map);

}