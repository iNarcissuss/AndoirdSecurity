package com.google.android.gms.games.multiplayer.realtime;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface RealTimeSocket
{
  public abstract void close();
  
  public abstract InputStream getInputStream();
  
  public abstract OutputStream getOutputStream();
  
  public abstract ParcelFileDescriptor getParcelFileDescriptor();
  
  public abstract boolean isClosed();
}

/* Location:
 * Qualified Name:     com.google.android.gms.games.multiplayer.realtime.RealTimeSocket
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */