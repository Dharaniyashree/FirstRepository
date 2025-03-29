package restAssuredBasics;

import io.restassured.path.json.JsonPath;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JsonPath js = new JsonPath(coursePrice());
		
		System.out.println("Number of courses: "+ js.getString("courses.size()"));
	
	}

	public static String coursePrice() {
		return "{\r\n"
				+"\"dashboard\":{\r\n"
				+"\"purchaseAmount\":910,\r\n"
				+"\"website\":\"rahulshettycom\"\r\n"
				+"},\r\n"
				+"\"courses\":[\r\n"
				+"{\"title\":\"English\",\r\n"
				+"\"price\":50,\r\n"
				+"\"copies\":6,\r\n"
				+"},\r\n"
				+"{\"title\":\"English\",\r\n"
				+"\"price\":50,\r\n"
				+"\"copies\":6,\r\n"
				+"},\r\n"
				+"{\"title\":\"English\",\r\n"
				+"\"price\":50,\r\n"
				+"\"copies\":6,\r\n"
				+"}\r\n"
				+"]\r\n"
				+ "}";
		
	}
}


