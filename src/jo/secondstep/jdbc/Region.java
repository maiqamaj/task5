package jo.secondstep.jdbc;

public class Region {

	private int regionId;

	public Region(int regionId, String regionName) {
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public int getRegionId() {
		return this.regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	private String regionName;

	public String getRegion_name() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

}
