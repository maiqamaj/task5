package jo.secondstep.jdbc;

public class Location {
	
	
		private int locationId;
		private String postalCode;
		private String streetAddress;
		private String city;
		private Country country;
		private String stateProvince;
		
		public Location(int locationId,String postalCode,String streetAddress,String city,String stateProvince)
		{
			this.locationId = locationId;
			this.postalCode = postalCode;
			this.streetAddress = streetAddress;
			this.city = city;
			this.stateProvince = stateProvince;
			
		}
	
		public int getLocationId()
		{
			return this.locationId;
		}
		public void setLocationId(int locationId)
		{
			this.locationId = locationId;
		}

		
		public String getStreetAddress()
		{
			return this.streetAddress;
		}
		public void setStreetAddress(String streetAddress)
		{
			this.streetAddress = streetAddress;
		}

		public String getPostalCode()
		{
			return this.postalCode;
		}
		public void setPostalCode(String postalCode)
		{
			this.postalCode = postalCode;
		}

		public String getCity()
		{
			return this.city;
		}
		public void setCity(String city)
		{
			this.city = city;
		}

	
		public String getStateProvince()
		{
			return this.stateProvince;
		}
		public void setStateProvince(String stateProvince)
		{
			this.stateProvince = stateProvince;
		}

		public Country getCountry()
		{
			return this.country;
		}
		public void setCountry(Country country)
		{
			this.country = country;
		}


		
}
