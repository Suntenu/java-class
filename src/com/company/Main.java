package com.company;

//import java.awt.*;
//import java.util.List;
//import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Math.abs;

public class Main {
    public static void print(int index,Object obj){
        System.out.println(String.format("{%d},%s",index,obj.toString()));

    }
    public static void demoOperation(){
        print(1,5/2);
        print(2,5+2);
        print(3,5-2);
        print(4,5*2);
        print(5,5<<2);
        print(6,5>>2);
        print(7,5&2);
        print(8,5|2);
        print(9,5^2);//异或
        print(10,5==2);
        print(11,5!=2);

    }
    public static void  demoString(){
        String str="Hello nowcoder";
        print(1,str.indexOf('e'));//返回字符/字符串在开始/指定位置的索引
        print(2,str.charAt(6));//返回指定字符位置
        print(3,str.codePointAt(5));//返回指定索引处码点
        print(4,str.compareTo("Hello nowcoder"));//字符串比较stcmp
        print(5,str.compareTo("Hello mowcoder"));//不同字符的ascll差
        print(6,str.compareToIgnoreCase("Hello mowcoder"));
        print(7,str.concat("!!"));//连接字符串
        print(8,str.contains("Hello"));//是否包含关键字
        print(9,str.endsWith("nowcoder"));//检查结尾
        print(10,str.startsWith("Hello"));//检查开头
        print(11,str.lastIndexOf('o'));//字符串在字符串中最后一次出现位置
        print(12,str.toUpperCase());//小写—>大写
        print(13,str.replace('o','a'));//替换o->a
        print(14,str.replaceAll("o|l","a"));//替换o|l->a
        print(15,str.replaceAll("Hello","hi"));//替换Hello->hi
        StringBuilder sb=new StringBuilder();
        sb.append(true);//加
        sb.append(1);
        sb.append(2.2);
        print(16,sb.toString());
        print(17,"a"+"b"+String.valueOf(12));
    }
    public static void demoList(){
        List<String> strList=new ArrayList();
        for(int i=0;i<4;++i){
            strList.add(String.valueOf(i));//添加i
        }
        print(1,strList);
        List<String> strListB=new ArrayList<String>();
        for(int i=0;i<4;++i){
            strListB.add(String.valueOf(i*i));
        }
        strList.addAll(strListB);//整体添加strListB
        print(2,strList);

        strList.remove(0);
        print(3,strList);
        strList.remove(String.valueOf(1));
        print(4,strList);
        print(5,strList.get(1));

        Collections.sort(strList);
        print(6,strList);
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        print(7,strList);

        Collections.reverse(strList);
        print(8,strList);

        int[] array=new int[]{1,2,3};
        print(9,array[1]);

    }
    public static void demoSet(){
        Set<String>strSet=new HashSet<String>();
        for(int i=0;i<3;++i){
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
            strSet.add(String.valueOf(i));
        }
        print(1,strSet);
        strSet.remove("1");
        print(2,strSet);
        strSet.addAll(Arrays.asList((new String[]{"A","B","C"})));
        print(4,strSet);

        for(String value:strSet){
            print(5,value);
        }
        print(6,strSet.isEmpty());
        print(7,strSet.size());
    }
    public static void demoKeyValue(){
        Map<String,String>map=new HashMap<>();
        for(int i=0;i<4;++i)
            map.put(String.valueOf(i),String.valueOf(i*i));
        print(1,map);
        for(Map.Entry<String,String>entry:map.entrySet())
            print(2,entry.getKey()+":"+entry.getValue());
        print(3,map.keySet());
        print(4,map.values());
        print(5,map.containsKey(("2")));
        print(6,map.get("1"));
        map.replace("1","A");
        print(7,map);
    }
    public static void demoException(){
        try{
            print(1,"hello");
            int a=2;
            a=a/0;
            String b=null;
            b.indexOf('a');
        }catch(NullPointerException npe){
            print(3,"NPE");
        }catch(Exception e){
            print(4,"Exception");
        }
        finally{
            print(2,"finally");
            //清理工作
        }

    }
    public static void demoCommon(){
        Random random=new Random();
        random.setSeed(1);
        for(int i=0;i<4;++i){
            print(1,random.nextInt(100));
            print(2,random.nextDouble());
        }
        List<Integer> array=Arrays.asList(new Integer[]{1,2,3,4,5});
        print(3,array);
        Collections.shuffle(array);
        print(4,array);
        Date date=new Date();
        print(5,date);
        print(6,date.getTime());
        //习题 已知今天 计算未来时间 星期几
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        print(7,df.format((date)));
        print(8,DateFormat.getDateInstance(DateFormat.FULL).format(date));
        print(9,UUID.randomUUID());
        print(10,Math.max(1,2));
        print(11,Math.ceil(2.2));
        print(12,Math.floor(2.5));
        print(13,Math.log(2.71));
    }
    public static void demoClass(){
        Talking animal=new Animal("Jim",1);
        animal.say();
        animal=new Human("Lei",11,"CN");
        animal.say();
    }
    public static void main(String[] args) {
        String c="Hello";
        System.out.println(c);
//        demoString();
//        demoList();
//        demoSet();
//        demoKeyValue();
//        demoException();
//        demoCommon();
        demoClass();

//        int[] A={0,0,0,0,0,0};
//        Main p=new Main();
//        p.Trial(1,4,A);
    }
    public  void Trial(int i,int n,int[] A){
        //i->行，n->列 A[i]表示第i行棋子位置，前i-1行完毕
        int j;
        if(i>n){//全部布局完毕
            for(i=1;i<=n;++i)
                System.out.print(A[i]);
            System.out.println();
        }
        else{
            for(j=1;j<=n;++j){
                A[i]=j;//尝试j位置
                if(fessible(i,A)) Trial(i+1,n,A);//判断是否符合条件
            }
        }
    }
    public boolean fessible(int r,int[] a){
        for(int m=0;m<r;m++)
        {
            if(a[m]==a[r])
                return false;
            else if(abs(a[r]-a[m])==(r-m))
                return false;
        }
        return true;
    }
}
