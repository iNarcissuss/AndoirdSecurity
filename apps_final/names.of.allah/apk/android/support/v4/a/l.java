package android.support.v4.a;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class l
{
  final IntentFilter a;
  final BroadcastReceiver b;
  boolean c;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("Receiver{");
    localStringBuilder.append(b);
    localStringBuilder.append(" filter=");
    localStringBuilder.append(a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.a.l
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */