package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;

final class m
  implements n
{
  public final Object a(Context paramContext)
  {
    return new EdgeEffect(paramContext);
  }
  
  public final void a(Object paramObject, int paramInt1, int paramInt2)
  {
    ((EdgeEffect)paramObject).setSize(paramInt1, paramInt2);
  }
  
  public final boolean a(Object paramObject)
  {
    return ((EdgeEffect)paramObject).isFinished();
  }
  
  public final boolean a(Object paramObject, float paramFloat)
  {
    ((EdgeEffect)paramObject).onPull(paramFloat);
    return true;
  }
  
  public final boolean a(Object paramObject, Canvas paramCanvas)
  {
    return ((EdgeEffect)paramObject).draw(paramCanvas);
  }
  
  public final void b(Object paramObject)
  {
    ((EdgeEffect)paramObject).finish();
  }
  
  public final boolean c(Object paramObject)
  {
    paramObject = (EdgeEffect)paramObject;
    ((EdgeEffect)paramObject).onRelease();
    return ((EdgeEffect)paramObject).isFinished();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.widget.m
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */