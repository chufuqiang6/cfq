package com.cfq.demo.util;

import java.util.List;
import java.util.Map;

import com.cfq.demo.entity.User;

public class test {
	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void Spider() {
		// List<User> userList=new ArrayList<User>();
		// for(int i=0;i<4;i++){
		// User userDTO = new User();
		// userDTO.setUserName("userName");
		// userDTO.setPassWord("loginName");
		// userList.add(userDTO);
		//
		// }
		User userDTO = new User();
		// userDTO.setPassWord("loginName");
		// 酷狗歌曲列表
		String url = "http://songsearch.kugou.com/song_search_v2?callback=jQuery112406080520686827604_1511232392051&keyword=ANightinGoa&page=1&pagesize=30&userid=-1&clientver=&platform=WebFilter&tag=em&filter=2&iscorrection=1&privilege_filter=0&_=1511232392063";
		// 酷狗单曲
		// String
		// songUrl="http://www.kugou.com/yy/index.php?r=play/getdata&hash=3DDF8B16990E499DB0690CB487AE2498&album_id=2237161&_=1511233822946";

		// String json= JsonUtil.getJsonString4JavaArray(userList.toArray());
		// String json= JsonUtil.getJsonString4JavaPOJO(userDTO);

		String getResult = HttpClientUtil.doGet(url);
		getResult = getResult.substring(getResult.indexOf("["),
				getResult.lastIndexOf("]") + 1);
		List<Map<String, Object>> resultMap = JsonUtil.getList4Json(getResult,Map.class);
		if (resultMap.size() > 0) {
			String AlbumID = (String) resultMap.get(0).get("AlbumID");
			String FileHash = (String) resultMap.get(0).get("FileHash");
			String songUrl = "http://www.kugou.com/yy/index.php?r=play/getdata&hash="
					+ FileHash + "&album_id=" + AlbumID + "&_=1511233822946";
			String songSingle = HttpClientUtil.doGet(songUrl);
			Map<String, Map<String, Object>> songMap = JsonUtil.getMap4Json(songSingle);
			// String erroCode=songMap.get("err_code").toString();
			// if(erroCode.equals("0")){
			if (songMap.get("data").size() > 0) {
				String songImg = (String) songMap.get("data").get("img");
				String albumName = (String) songMap.get("data").get("album_name");
				System.out.println(songImg);
				// }

			}
			System.out.println(getResult);
		}

	}

}
