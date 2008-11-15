// Created by plusminus on 13:24:05 - 21.09.2008
package org.andnav.osm.contributor.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

import org.andnav.osm.contributor.util.constants.OSMContributorConstants;
import org.andnav.osm.util.BoundingBoxE6;

/**
 * 
 * @author Nicolas Gramlich
 *
 */
public class Util implements OSMContributorConstants{
	// ===========================================================
	// Constants
	// ===========================================================
	
	public static final SimpleDateFormat UTCSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
	{
		UTCSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	
	public static final String convertTimestampToUTCString(final long aTimestamp){
		return UTCSimpleDateFormat.format(new Date(aTimestamp));
	}
	
	public static boolean isSufficienDataForUpload(final ArrayList<RecordedGeoPoint> recordedGeoPoints){
		if(recordedGeoPoints == null)
			return false;
		
		if(recordedGeoPoints.size() < MINGEOPOINTS_FOR_OSM_CONTRIBUTION)
			return false;
		
		final BoundingBoxE6 bb = BoundingBoxE6.fromGeoPoints(recordedGeoPoints);
		final int diagMeters = bb.getDiagonalLengthInMeters(); 
		if(diagMeters < MINDIAGONALMETERS_FOR_OSM_CONTRIBUTION)
			return false;
		
		return true;
	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
}
