package ai;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import org.json.simple.*;
import org.json.simple.parser.*;

public class RequestResponse {
//any news regarding kareena kapoor's child
    //Variable
    private final String USER_AGENT = "Mozilla/5.0";
   //private final String server_url = "http://gs98.ddns.net/"; /*deploy*/
    //private final String server_url = "http://103.109.216.66/"; 
 //  private final String server_url = "http://aiproject7579.ddns.net/";
     private final String server_url = "http://ansh998.ddns.net/";
 //private final String server_url = "http://localhost/"; /*tester*/
    private StringBuffer response = new StringBuffer();
    private String inputLine;
    private int timeout = 10000;
    
    //JSON Enoder
    public JSONObject encodeJSON(String arr[][])
    {
        JSONObject obj = new JSONObject();
        for(int i=0; i < arr.length; i++)
            obj.put(arr[i][0], arr[i][1]);
      
        return obj;
    }

    public JSONObject decodeJson(StringBuffer s)
    {       
      try
      {
        Object o = new JSONParser().parse(s.toString());
        JSONArray arr = (JSONArray)o;
        return (JSONObject)arr.get(0);
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
        return null;
    }
    
    public JSONObject[] decodeJsonArray(StringBuffer s)
    {       
      try
      {
        Object o = new JSONParser().parse(s.toString());
        JSONArray arr = (JSONArray)o;
        JSONObject temp[] = new JSONObject[arr.size()];
        for(int i=0;i<arr.size();i++)
            temp[i] = (JSONObject)arr.get(i);
        return temp;
      }
      catch (Exception e)
      {
        System.out.println(e);
      }
        return null;
    }
    
    //POST Request
    public StringBuffer postRequest(String _url, JSONObject urlparams) throws Exception 
    {
	String url = server_url + _url;
	URL request_url = new URL(url);
        response.delete(0, response.capacity());
	HttpURLConnection con = (HttpURLConnection) request_url.openConnection();
        
        System.out.println("Post Called");
        //Setting Parameters
	con.setRequestMethod("POST");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(timeout);
        con.setDoInput(true);
	con.setDoOutput(true);
        
        //Making Request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlparams.toString());
	wr.flush();
	wr.close();
        
        //Logging
        System.out.println("URL : " + url);                                                                  
	System.out.println("Post parameters : " + urlparams.toString());
	System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Response : " + con.getResponseMessage());
        System.out.println("Content Type : " + con.getContentType());
        
        //Getting responce
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	while ((inputLine = in.readLine()) != null) 
		response.insert(0,inputLine);
	in.close();
        
        System.out.println("Reply From web api: \n Response Data :" + response.toString());
        return response;
    }
    
    //GET Request
    public StringBuffer getRequest(String _url) throws Exception 
    {
	String url = server_url + _url;
	URL request_url = new URL(url);
        response.delete(0, response.capacity());
	HttpURLConnection con = (HttpURLConnection) request_url.openConnection();
     
        System.out.println("Get Called");
        //Setting Parameters
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setConnectTimeout(timeout);
        con.setDoInput(true);
	con.setDoOutput(true);
        
        //Logging
        System.out.println("URL : " + url);                                                                  
	System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Response : " + con.getResponseMessage());
        System.out.println("Content Type : " + con.getContentType());
        
        //Getting responce
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	while ((inputLine = in.readLine()) != null) 
		response.insert(0,inputLine);
	in.close();
        
        System.out.println("Reply From web api: \n Response Data :" + response.toString());
        return response;
    }
    
    public StringBuffer deleteRequest(String _url) throws Exception 
    {
	String url = server_url + _url;
	URL request_url = new URL(url);
        response.delete(0, response.capacity());
	HttpURLConnection con = (HttpURLConnection) request_url.openConnection();
     
        System.out.println("Delete Called");
        //Setting Parameters
	con.setRequestMethod("DELETE");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setConnectTimeout(timeout);
        con.setDoInput(true);
	con.setDoOutput(true);
        
        //Logging
        System.out.println("URL : " + url);                                                                  
	System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Response : " + con.getResponseMessage());
        System.out.println("Content Type : " + con.getContentType());
        
        //Getting responce
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	while ((inputLine = in.readLine()) != null) 
		response.insert(0,inputLine);
	in.close();
        
        System.out.println("Reply From web api: \n Response Data :" + response.toString());
        return response;
    }
    
    //PUT Request
    public StringBuffer putRequest(String _url, JSONObject urlparams) throws Exception 
    {
	String url = server_url + _url;
	URL request_url = new URL(url);
        response.delete(0, response.capacity());
	HttpURLConnection con = (HttpURLConnection) request_url.openConnection();
        
        System.out.println("Put Called");
        //Setting Parameters
	con.setRequestMethod("PUT");
	con.setRequestProperty("User-Agent", USER_AGENT);
	con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json");
        con.setConnectTimeout(timeout);
        con.setDoInput(true);
	con.setDoOutput(true);
        
        //Making Request
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlparams.toString());
	wr.flush();
	wr.close();
        
        //Logging
        System.out.println("URL : " + url);                                                                  
	System.out.println("Put parameters : " + urlparams.toString());
	System.out.println("Response Code : " + con.getResponseCode());
        System.out.println("Response : " + con.getResponseMessage());
        System.out.println("Content Type : " + con.getContentType());
        
        //Getting responce
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	while ((inputLine = in.readLine()) != null) 
		response.insert(0,inputLine);
	in.close();
        
        System.out.println("Reply From web api: \n Response Data :" + response.toString());
        return response;
    }
    
    //Optional<String[][]> ar,
    /*public JSONObject MakeRequest( String type, String url, Optional<String[][]> ar)
    {
        JSONObject urlparams = null;
        System.out.println("Make Called");
        if(ar.isPresent())
           urlparams =  encodeJSON(ar.get());
        
        try
        {
            switch(type)
            {
                case "GET":
                {
                    return getRequest(url);
                }

                case "POST":
                {
                    return postRequest(url,urlparams);
                }
                
                default:
                {
                    return null;
                }
            }
        }
        catch(Exception er)
        {
            System.out.println(er.getMessage());
            return (JSONObject) new JSONObject().put("Error",er.getMessage());
        }
    }
    
    public static void main(String arg[]) throws Exception
    {
        String arr[][] = new String[7][2];
        RequestResponse req = new RequestResponse();
        System.out.println(req.MakeRequest("POST", "api/data", arr));
        //req.MakeRequest("POST", "api/data");
    }
*/
}
