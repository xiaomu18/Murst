/*
 * Copyright (c) 2014-2024 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.StatsListener;
import net.minecraft.client.gui.screen.StatsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.Text;
import net.wurstclient.WurstClient;

@Mixin(StatsScreen.class)
public abstract class StatsScreenMixin extends Screen implements StatsListener
{
	private StatsScreenMixin(WurstClient wurst, Text title)
	{
		super(title);
	}
	
	@Inject(at = @At("TAIL"), method = "createButtons()V")
	private void onCreateButtons(CallbackInfo ci)
	{
		if(WurstClient.INSTANCE.getOtfs().disableOtf.shouldHideEnableButton())
			return;
		
		ButtonWidget disableWurstButton =
			ButtonWidget.builder(Text.literal(""), this::disableWurst)
				.dimensions(width - 20, 0, 20, 20).build();
		disableWurstButton.setAlpha(0);

		ButtonWidget enableWurstButton =
				ButtonWidget.builder(Text.literal(""), this::enableWurst)
						.dimensions(0, 0, 20, 20).build();
		enableWurstButton.setAlpha(0);

		if (WurstClient.INSTANCE.isEnabled()) {
			enableWurstButton.active = false;
		} else {
			disableWurstButton.active = false;
		}

		addDrawableChild(disableWurstButton);
		addDrawableChild(enableWurstButton);
	}
	
	private void disableWurst(ButtonWidget button)
	{
		WurstClient.INSTANCE.setEnabled(false);
		button.active = false;
	}

	private void enableWurst(ButtonWidget button)
	{
		WurstClient.INSTANCE.setEnabled(true);
		button.active = false;
	}
}
