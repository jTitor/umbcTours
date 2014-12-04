package com.example.umbctours;

public class ButtonInfo {
	private int bldgId;
	private String label;
	
	public int GetBuildingId()
	{
		return bldgId;
	}
	
	public String GetLabel()
	{
		return label;
	}
	
	public ButtonInfo(int pBldgId, String pLabel)
	{
		bldgId = pBldgId;
		label = pLabel;
	}
}
