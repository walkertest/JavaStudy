# 环境搭建
windows安装：https://zhuanlan.zhihu.com/p/423928097
jar包下载：https://www.antlr3.org/download/
```aidl
编译文件
java org.antlr.Tool E.g
```
idea插件：antlrv4

# antlr实现一个科学计算器
* 文章:https://zhuanlan.zhihu.com/p/438163115
* 首先定义语法文件 [CalExpr.g4](CalExpr.g4)，并使用工具生成相关的parser和lexer
* 自定义visitor @see MyCalVistor 以及相关的对象方法
* 编写测试类，并运行. @see CalExprTest

# 相关学习文档
* antlrV4权威指南


# 尝试翻译TARS文件（自己的目标任务）
* antlr官方的一些建议：https://github.com/antlr/antlr4/issues/3652
* tars tools 里面有一些maven plugin的类似语法文件帮助.

# antlr基本语法
## tokens
tokens {Token1 ... TokenN}
例如为向量表示定义虚词法单元:

## 语法
语法基于EBNF（扩展的巴科斯范式）
这意味着，在ANTLR中既可以使用BNF元语言符号
冒号（:）表示推导，
竖线（|）表示或，
也可以使用扩展的元语言符号如
星号（*）表示出现0次或以上。
问号（?）表示出现0次或1次。
加号（+）表示出现1次或以上。

$channel = HIDDEN用法:https://blog.csdn.net/jazywoo123/article/details/7647775


fragment: 被别的规则所引用的片段


names must be identical: 语法文件名必须跟grammar指定的名称一致，否则ANTLR生成时会报错

-> 语法含义：
^ 语义：
~语义：
# 相关学习
* 正则表达式
* 编译原理



