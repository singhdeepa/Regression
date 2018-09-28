package in.licious.test;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class RestAssured {
@SuppressWarnings("deprecation")
@Test
public void getTest() throws Throwable
{
	String sURL="http://52.66.9.219:9200/_sql?sql=select sum(revenue),sum(quantity) from aggregation-data where date IN('2018-07-23', '2018-07-16', '2018-07-09', '2018-07-02') and product_id ='pr_5746a7a8198ef' and hub_id = 4";
	Response response=io.restassured.RestAssured.get("http://52.66.9.219:9200/_sql?sql=select sum(revenue),sum(quantity) from aggregation-data where date IN('2018-07-23', '2018-07-16', '2018-07-09', '2018-07-02') and product_id ='pr_5746a7a8198ef' and hub_id = 4");
	int stcode=response.getStatusCode();
	String resbody=response.asString();
	
	System.out.println(resbody);
	Assert.assertEquals(200, stcode);
	URL url = new URL(sURL);
    URLConnection request = url.openConnection();
    request.connect();
	JsonParser jp = new JsonParser(); //from gson
    JsonElement root = (JsonElement) jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
    JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object. 
    String value = rootobj.get("value").getAsString(); //just grab the zipcode
    System.out.println(value);
    
}
}
