package com.cn.dsyg.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cn.common.action.BaseAction;
import com.cn.dsyg.dto.ChartDto;
import com.cn.dsyg.service.ChartService;


public class ChartAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3220766635860750596L;

	private static final Logger log = LogManager.getLogger(ChartAction.class);

	private static final String SUCCESS = null;

	private static final String ERROR = null;

	private String str;  
	private String series;  
	private String series_X;  
	
	public String getSeries_X() {
		return series_X;
	}
	public void setSeries_X(String series_X) {
		this.series_X = series_X;
	}

	private String period;  
	private ChartService chartService;

	private JSONArray m_jsonArr;
	
	public JSONArray getM_jsonArr() {
		return m_jsonArr;
	}
	public void setM_jsonArr(JSONArray m_jsonArr) {
		this.m_jsonArr = m_jsonArr;
	}
	public ChartService getChartService() {
		return chartService;
	}
	public void setChartService(ChartService chartService) {
		this.chartService = chartService;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getStr() {  
        return str;  
    }  
    public void setStr(String str) {  
        this.str = str;  
    }
    
	public String showSaleInfoMainChartAction(){  
    	try{
	        str  = "[49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]";  
	        setStr(str);
//	        series = "[{ name: '方', data:[59.9, 81.5, 96.4, 129.8, 124.0, 196.0, 132.6, 140.5, 220.4, 214.1, 100.6, 50.4]},";
//	        series += " {name: '陈', data:[49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4] }] ";

	    	JSONArray jsonArr=getM_jsonArr();
	    	series = jsonArr.toString();
	        setSeries(series); 
	        setSeries_X(getSeries_X()); 
            System.out.println("----series_Y--->" + series); 
            System.out.println("----series_X--->" + getSeries_X()); 

	        
	        return SUCCESS;  
		} catch(Exception e) {
			log.error("showSaleInfoMainChartAction error:" + e);
			return ERROR;
		}
	}
	
	//------------------------------------------------------------------

	
	public Map<String, String> getInitDataMap(int i_fy, int i_ty, int i_fm, int i_tm) {  
		Map<String, String> data_map = new HashMap<String, String>();

		int i_year = 0;
		int i_month = 0;
		for (int i = 0; i < (i_ty - i_fy)*12 + (i_tm - i_fm) + 1; i++ ){
			i_year = i_fy  + (i + i_fm)/12;
			i_month = (i + i_fm)%12; 
			if (i_month == 0){
				i_year--;
				i_month = 12;
			}
			data_map.put((Integer.toString(i_year)+String.format("%02d", i_month)),"0.00");
            System.out.println("key:" +(Integer.toString(i_year)+String.format("%02d", i_month)));
		}
		return data_map;
	}

	public Map<String, String> setDataMap( Map<String, String> data_map, ChartDto chd ) {  
		String str = data_map.get(chd.getX_Year()+"01");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"01");
			data_map.put(chd.getX_Year()+"01",chd.getY_Month_01());
		}
		str = data_map.get(chd.getX_Year()+"02");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"02");
			data_map.put(chd.getX_Year()+"02",chd.getY_Month_02());
		}
		str = data_map.get(chd.getX_Year()+"03");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"03");
			data_map.put(chd.getX_Year()+"03",chd.getY_Month_03());
		}
		str = data_map.get(chd.getX_Year()+"04");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"04");
			data_map.put(chd.getX_Year()+"04",chd.getY_Month_04());
		}
		str = data_map.get(chd.getX_Year()+"05");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"05");
			data_map.put(chd.getX_Year()+"05",chd.getY_Month_05());
		}
		str = data_map.get(chd.getX_Year()+"06");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"06");
			data_map.put(chd.getX_Year()+"06",chd.getY_Month_06());
		}
		str = data_map.get(chd.getX_Year()+"07");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"07");
			data_map.put(chd.getX_Year()+"07",chd.getY_Month_07());
		}
		str = data_map.get(chd.getX_Year()+"08");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"08");
			data_map.put(chd.getX_Year()+"08",chd.getY_Month_08());
		}
		str = data_map.get(chd.getX_Year()+"09");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"09");
			data_map.put(chd.getX_Year()+"09",chd.getY_Month_09());
		}
		str = data_map.get(chd.getX_Year()+"10");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"10");
			data_map.put(chd.getX_Year()+"10",chd.getY_Month_10());
		}
		str = data_map.get(chd.getX_Year()+"11");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"11");
			data_map.put(chd.getX_Year()+"11",chd.getY_Month_11());
		}
		str = data_map.get(chd.getX_Year()+"12");
		if (str!=null && str !=""){
			data_map.remove(chd.getX_Year()+"12");
			data_map.put(chd.getX_Year()+"12",chd.getY_Month_12());
		}
		return data_map;
	}
	
	public static Map sort(Map map) { 
        Map<Object, Object> mapVK = new TreeMap<Object, Object>( 
            new Comparator<Object>() { 
                public int compare(Object obj1, Object obj2) { 
                    String v1 = (String)obj1; 
                    String v2 = (String)obj2; 
                    int s = v2.compareTo(v1); 
                    return -s; 
                } 
            } 
        ); 

		Set col = map.keySet(); 
		Iterator iter = col.iterator(); 
        while (iter.hasNext()) { 
            String key = (String) iter.next(); 
            String value = (String) map.get(key); 
            mapVK.put(key, value); 
        } 
        return mapVK; 
    } 
	
    public String getDataAction() {  
		log.error("getDataAction");
    	JSONArray arr = getData();
        return SUCCESS;  
    }

    public JSONArray setJsonData(JSONArray jsonArr, String use_id, Map<String, String> item_map ) throws JSONException {  
        JSONObject item = null;  

    	//Add user information into json array 
        item = new JSONObject(); 
        String tmp_Series_X = getSeries_X();

		item.put("name", use_id.replace("\"", ""));            	
    	Set sortSet = item_map.entrySet(); 
        Iterator ii = sortSet.iterator();
        ArrayList arrY=new ArrayList();
        while(ii.hasNext()){ 
            Map.Entry<String, String> entry1=(Map.Entry<String, String>)ii.next(); 
            System.out.println(entry1.getKey() + "-------->" + entry1.getValue()); 
            arrY.add(entry1.getValue());  

            if (tmp_Series_X == null || tmp_Series_X=="")
            	tmp_Series_X = entry1.getKey();
            else
            	tmp_Series_X = tmp_Series_X + "," + entry1.getKey();  
        } 
        
        if (getSeries_X()== null || getSeries_X()== "" )
        	setSeries_X("[" + tmp_Series_X + "]");

		item.put("data", arrY);            	
        jsonArr.put(item);  		         			        	
        return jsonArr;  
    }
    
    
    
	public JSONArray getData() {  
    	String from_date;
    	String to_date;
    	int period_days = -180;
    	int i_fy;
    	int i_ty;
    	int i_fm;
    	int i_tm;
    	String user_id = "";
    	String tmp_user_id = "";
    	JSONArray jsonArr = new JSONArray();  
        JSONObject item = null;  
		log.error("getData");
        System.out.println("-------->"); 
    	    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
//        to_date = sdf.format(new Date(System.currentTimeMillis()));
//        from_date = sdf.format(add(new Date(System.currentTimeMillis()), period_days));

        from_date= "2015-06-01";
        to_date = "2015-12-31";
        System.out.println("from_date:" + from_date);
        System.out.println("to_date:" + to_date);

        i_fy =  Integer.parseInt(from_date.substring(2,4));
        i_ty =  Integer.parseInt(to_date.substring(2,4));
        i_fm =  Integer.parseInt(from_date.substring(5,7));
        i_tm =  Integer.parseInt(to_date.substring(5,7));
        
        try {
        	List<ChartDto>  list = new ArrayList<ChartDto>();

	        list = chartService.queryPurchaseByDate("T1", from_date, to_date);
	        if (list==null || list.size()<= 0)
	            System.out.println("list.size error");	        	
	        if (list.size() > 0) {
	            System.out.println("list.size:" + list.size());
	        }
            Map<String, String> item_map = null;
            Map<String, String> temp_item_map = null;
            Map<String, String> user_item_map = null;
            item = new JSONObject();  
            
	        for (int z = 0; z < list.size(); z++) {  
	            System.out.println("Z:" + z);
	        	ChartDto chd = list.get(z);
	        	user_id = chd.getHandler();	        	
	            System.out.println("user_id_loop:" + user_id);
	        	if (user_id != tmp_user_id){
	        		// part of every user_id 
		            System.out.println("This user_id is:" + user_id);
		            if (temp_item_map != null){
		            	// put pre_user's data into array
			        	item_map= sort(user_item_map);
			        	jsonArr = setJsonData(jsonArr, tmp_user_id,  item_map );
		            }
		            // initial the user's data map
		            temp_item_map = getInitDataMap(i_fy, i_ty, i_fm, i_tm);
	        	}
	            if (temp_item_map != null){
	            	// add user data to his data map
	            	user_item_map = setDataMap(temp_item_map, chd);
	            }
	        	tmp_user_id = user_id;	        	
	        }	                  
            if (temp_item_map != null){
	        	item_map= sort(user_item_map);
	        	jsonArr = setJsonData(jsonArr, tmp_user_id,  item_map );
            }
            
//            JSONObject[] arr=new JSONObject[jsonArr.length()];
            System.out.println("jsonArr length:" + jsonArr.length());
    	    System.out.println("JO: " + jsonArr);  
    	    setM_jsonArr(jsonArr);
            
		}
        catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
        return(jsonArr);  
    }	
      
    public Date add(Date day,int dist) {  
        Calendar calendar = new GregorianCalendar();  
        calendar.setTime(day);  
        calendar.add(calendar.DATE, dist);  
        day = calendar.getTime();  
        return day;  
    }  	
}