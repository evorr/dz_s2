// 1.Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.util.HashMap;
import java.util.Set;

public class zadacha_1 {
    public static void main (String[] args) {
        String jsonString = "{\"name\":\"Ivanov\",\"country\":\"Russia\",\"city\":\"Moscow\",\"age\":\"null\"}";
        String result = "select * from students where ";
        StringBuilder request = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        String new_str = jsonString.replace("\\","");
        new_str = new_str.replace("{","");
        new_str = new_str.replace("}","");
        new_str = new_str.replaceAll("\"","");
        String[] new_arr = new_str.split(",");
        for (int i = 0; i < new_arr.length; i++) {
            String[] sub_str = new_arr[i].split(":");
            map.put(sub_str[0],sub_str[1]);
        }
        Set<String> keys = map.keySet();
        request.append(result);
        String delimetr = "";
        for (String key:keys) {
            if(!map.get(key).equals("null")){
                request.append(delimetr);
                request.append(key + "=" + map.get(key));


            }
            else{
                request.append(" ");
            }
            delimetr = " and ";

        }
        System.out.println(request);

    }

}
