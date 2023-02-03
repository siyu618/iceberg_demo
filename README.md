
## demo for iceberg

### Steps to set up:


1. Install Hadoop by following [link](https://medium.com/analytics-vidhya/hadoop-how-to-install-in-5-steps-in-windows-10-61b0e67342f8#:~:text=1%20Prerequisites.%20%2A%20RAM%20%E2%80%94%20Min.%208GB%2C%20if,share%20it%20with%20your%20friends%20and%20colleagues.%20)
   * version 3.3 to match spark version in pom.xml 
2. In Intellij IDEA, start jvm with " --add-exports=java.base/sun.net.util=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-opens=java.base/java.nio=ALL-UNNAMED"
   * path: Run-> Edit Configurations -> Modify options -> Environment Variables
   * The one added in maven-surefire-plugin does not take effect.


### Reference
1. https://zhuanlan.zhihu.com/p/453130996
2. optimization for lots of small files: https://zhuanlan.zhihu.com/p/473731690