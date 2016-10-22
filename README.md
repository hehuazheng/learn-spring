# learn-spring
br: multi-datasource-20160323
插入一条数据，需要在db1中记入一条记录，在db2中记录。改为批量时的事务处置方式，把db1中的操作置于一个事物中记为db1op，db2中的置于另一个事务中，记为db2op，在外层封装一层主事务dbop3，在dbop3中依次调用dbop1,dbop2即可

# activemq
需要设置consumer失败重试时需要在onMessage里抛出异常，具体配置参照分支


# spring aop
使用时扫描Controller 时必须排除org.springframework.stereotype.Service或Component，否则将导致aop不生效
