用spring组装一个biz层+dao层操作:
1. Dao接口 + JdbcDao实现类
     public interface UserDao{
              public void add(   String uname );
    }
2. Biz接口 + Biz实现类
    public interface UserBiz{
            public void addUser( String name);
   }

   Biz实现类  里面必须有  Dao层的依赖.
3. 写一个测试类，用spring组装以上的代码 .

需求二:
写一个类:   加法类
   public interface JiShuan{
             public int add(    Num num);
             public int mul( Num num);
   }

   public class Add implements JiShuan{
            public int add(    Num num     ){
                      return num.getX()+num.getY();
            }
           public int mul( Num num){}
   }

写一类: 业务类
public class  JiShuanBiz{
     public JiShuan jiShuan;      //接口的引用.

      public void add(       int x, int y    ){
            System.out.println(    jiShuan.add(     new Num( x, y)    )  );
       }
}


用spring组装以上的类， 测试以上的操作.

