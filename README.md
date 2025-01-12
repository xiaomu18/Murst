# Murst Client

这里是 Wurst Client 的一个魔改版本。
致力于使 Wurst Client 的功能适应小游戏服务器

目前更改如下：
1. 添加 Team 功能。开启此功能后将会识别小游戏的玩家队伍

作用域：  
TriggerBot: 不会攻击已识别的队友。  
AimAssist: 只瞄准已识别的敌人。不会攻击非玩家  
Killaura: 只攻击已识别的敌人。不会攻击非玩家  
PlayerESP: Boxes 显示为队伍颜色。队友的 Line 可设置为不显示或显示成白色。  

4. 可以调整 PlayerESP 绘制线条的透明度
5. 增加了 .playerlist 命令，可通过服务端发送的数据查看在线玩家和他人游戏模式
6. 移除 Wurst Updater
7. 使 Wurst Logo 处于 Never 显示模式


## 使用方法 (for users)

从 [Releases](https://github.com/xiaomu18/Murst/releases/) 中下载最新的构建版本  
将 jar 文件放入装好 Fabric loader 的 MC 客户端的 mods 文件夹中，然后就可以启动了。  
Then Enjoy it ~

## Setup (for developers)

(This assumes that you are using Windows with [Eclipse](https://www.eclipse.org/downloads/) and [Java Development Kit 17](https://adoptium.net/?variant=openjdk17&jvmVariant=hotspot) already installed.)

1. Run this command in PowerShell:

```
./gradlew.bat genSources eclipse --no-daemon
```

2. In Eclipse, go to `Import...` > `Existing Projects into Workspace` and select this project.

## License

This code is licensed under the GNU General Public License v3. **You can only use this code in open-source clients that you release under the same license! Using it in closed-source/proprietary clients is not allowed!**
