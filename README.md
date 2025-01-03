# Murst Client

这里是 Wurst Client 的一个魔改版本。

目前更改如下：
1. 为 TriggerBot 添加 Team(队伍) 选项。开启后不会攻击与你戴相同颜色帽子的玩家。
2. 为 PlayerESP 添加 Team(队伍) 选项。开启后 Box 将显示为玩家队伍颜色，若无队伍则显示为白色。与队友的连线将显示为白色。
3. 为 AimAssist 添加 Team(队伍) 选项。开启后不会瞄准非玩家和队友。
3. 移除 Wurst Updater
4. 为游戏内的 Wurst Logo 添加了 Never 选项


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
