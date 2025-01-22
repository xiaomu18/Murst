/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.other_features;

import net.wurstclient.DontBlock;
import net.wurstclient.SearchTags;
import net.wurstclient.other_feature.OtherFeature;
import net.wurstclient.settings.CheckboxSetting;

@SearchTags({"turn off", "hide wurst logo", "ghost mode", "stealth mode",
	"vanilla Minecraft"})
@DontBlock
public final class DisableOtf extends OtherFeature
{
	private final CheckboxSetting hideEnableButton = new CheckboxSetting(
		"Completely disabled",
		"在禁用 Murst 后不再开放启用通道。彻底禁用 Murst"
			+ " You will have to restart the game to re-enable Wurst.",
		false);

	private final CheckboxSetting disableOnStart = new CheckboxSetting(
			"Disable On Start",
			"每次启动 Minecraft 时默认使 Murst 处于禁用状态。\n你可以在进入游戏再启用 Murst",
			false);
	
	public DisableOtf()
	{
		super("Disable Murst", "点击统计信息页面的左上角和右上角分别可以启用、禁用 Murst。");
		addSetting(hideEnableButton);
		addSetting(disableOnStart);
	}
	
	public boolean shouldHideEnableButton()
	{
		return !WURST.isEnabled() && hideEnableButton.isChecked();
	}
	public boolean shouldDisableOnStart() { return disableOnStart.isChecked(); }
}
