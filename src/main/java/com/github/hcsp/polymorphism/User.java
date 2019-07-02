package com.github.hcsp.polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class User {
    /** 用户ID，数据库主键，全局唯一 */
    private final Integer id;

    /** 用户名 */
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public static List<User> filter(List<User> users,Predicate<User> predicate){
        List<User> results = new ArrayList<>();
        for (User user : users) {
            if (predicate.test(user)) {
                results.add(user);
            }
        }
        return results;
    }

//    private interface Verdict{
//        boolean cd(User user);
//    }

    // 过滤ID为偶数的用户
//    public static class EvenIdfilter implements Verdict{
//
//        @Override
//        public boolean cd(User user) {
//            return user.id % 2 == 0;
//        }
//    }
    public static List<User> filterUsersWithEvenId(List<User> users)  {
        return filter(users, user -> user.id % 2 == 0);
    }

    // 过滤姓张的用户
//    public static  class NameZhang implements Verdict{
//
//        @Override
//        public boolean cd(User user) {
//            return user.name.startsWith("张");
//        }
//    }
    public static List<User> filterZhangUsers(List<User> users) {
        return filter(users, user -> user.name.startsWith("张"));
    }

    // 过滤姓王的用户
//    public static class NameWang implements Verdict{
//
//        @Override
//        public boolean cd(User user) {
//            return user.name.startsWith("王");
//        }
//    }
    public static List<User> filterWangUsers(List<User> users) {
        return filter(users, user -> user.name.startsWith("王"));
    }

}