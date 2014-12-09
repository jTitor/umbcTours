package com.example.umbctours;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Audio {
	private static Audio _instance;
	
	public static Audio GetInstance()
	{
		return _instance;
	}
	
	public static void SetInstance(Audio newInstance)
	{
		_instance = newInstance;
	}
	
	private SoundPool sounds;
	private int[] soundIds;
	
	public enum SoundCue
	{
		ButtonPress,
		_Count
	};
	
	public Audio()
	{
		//Create the sound pool.
		//We're targeting APIs < 21,
		//so we must use the depreciated constructor.
		sounds = new SoundPool(16, AudioManager.STREAM_MUSIC, 0);
		soundIds = new int[SoundCue._Count.ordinal()];
		for(int i = 0; i < soundIds.length; ++i)
		{
			soundIds[i] = -1;
		}
	}
	
	public boolean LoadSound(Context context, int resId, SoundCue cueType)
	{
		if(cueType == SoundCue._Count)
		{
			return false;
		}
		//Otherwise, load the sound into the sound ID array.
		soundIds[cueType.ordinal()] = sounds.load(context, resId, 1);
		return true;
	}
	
	public void PlaySound(SoundCue cueType)
	{
		if(cueType == SoundCue._Count)
		{
			return;
		}
		
		int soundId = soundIds[cueType.ordinal()];
		if(soundId >= 0)
		{
			sounds.play(soundId, 1, 1, 0, 0, 1);
		}
	}
}
