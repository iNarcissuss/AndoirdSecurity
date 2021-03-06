package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.internal.ji;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent
{
  private final int Vf;
  private final List<Geofence> Vg;
  private final Location Vh;
  private final int pH;
  
  private GeofencingEvent(int paramInt1, int paramInt2, List<Geofence> paramList, Location paramLocation)
  {
    pH = paramInt1;
    Vf = paramInt2;
    Vg = paramList;
    Vh = paramLocation;
  }
  
  public static GeofencingEvent fromIntent(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return new GeofencingEvent(paramIntent.getIntExtra("gms_error_code", -1), getGeofenceTransition(paramIntent), getTriggeringGeofences(paramIntent), (Location)paramIntent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
  }
  
  private static int getGeofenceTransition(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
    if (i == -1) {}
    while ((i != 1) && (i != 2) && (i != 4)) {
      return -1;
    }
    return i;
  }
  
  private static List<Geofence> getTriggeringGeofences(Intent paramIntent)
  {
    Object localObject = (ArrayList)paramIntent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
    if (localObject == null) {
      return null;
    }
    paramIntent = new ArrayList(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramIntent.add(ji.h((byte[])((Iterator)localObject).next()));
    }
    return paramIntent;
  }
  
  public int getErrorCode()
  {
    return pH;
  }
  
  public int getGeofenceTransition()
  {
    return Vf;
  }
  
  public List<Geofence> getTriggeringGeofences()
  {
    return Vg;
  }
  
  public Location getTriggeringLocation()
  {
    return Vh;
  }
  
  public boolean hasError()
  {
    return pH != -1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.location.GeofencingEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */