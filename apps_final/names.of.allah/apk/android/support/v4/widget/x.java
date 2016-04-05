package android.support.v4.widget;

import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class x
  extends w
{
  private Method a;
  private Field b;
  
  x()
  {
    try
    {
      a = View.class.getDeclaredMethod("getDisplayList", null);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;)
      {
        try
        {
          b = View.class.getDeclaredField("mRecreateDisplayList");
          b.setAccessible(true);
          return;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", localNoSuchFieldException);
        }
        localNoSuchMethodException = localNoSuchMethodException;
        Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", localNoSuchMethodException);
      }
    }
  }
  
  public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
  {
    if ((a != null) && (b != null)) {
      try
      {
        b.setBoolean(paramView, true);
        a.invoke(paramView, null);
        super.a(paramSlidingPaneLayout, paramView);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("SlidingPaneLayout", "Error refreshing display list state", localException);
        }
      }
    }
    paramView.invalidate();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */