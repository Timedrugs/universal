#####URL：https://www.jianshu.com/p/090087c22820

binlog二进制日志是server层的，主要是做主从复制，时间点恢复使用

redo log重做日志是InnoDB存储引擎层的，用来保证事务安全

undo log回滚日志保存了事务发生之前的数据的一个版本，可以用于回滚，同时可以提供多版本并发控制下的读（MVCC），也即非锁定读


redo log ： 事务未提交前
bing log : 日志提交之后
undo log : 事务开始之前