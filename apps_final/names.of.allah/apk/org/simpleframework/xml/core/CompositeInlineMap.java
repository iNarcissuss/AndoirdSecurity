package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeInlineMap
  implements Repeater
{
  private final Entry entry;
  private final MapFactory factory;
  private final Converter key;
  private final Style style;
  private final Converter value;
  
  public CompositeInlineMap(Context paramContext, Entry paramEntry, Type paramType)
  {
    factory = new MapFactory(paramContext, paramType);
    value = paramEntry.getValue(paramContext);
    key = paramEntry.getKey(paramContext);
    style = paramContext.getStyle();
    entry = paramEntry;
  }
  
  private Object read(InputNode paramInputNode, Map paramMap)
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Object localObject = key.read(paramInputNode);
      paramInputNode = value.read(paramInputNode);
      if (paramMap != null) {
        paramMap.put(localObject, paramInputNode);
      }
      paramInputNode = localInputNode.getNext(str);
    }
    return paramMap;
  }
  
  private void write(OutputNode paramOutputNode, Map paramMap, Mode paramMode)
  {
    String str = entry.getEntry();
    str = style.getElement(str);
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      OutputNode localOutputNode = paramOutputNode.getChild(str);
      Object localObject2 = paramMap.get(localObject1);
      localOutputNode.setMode(paramMode);
      key.write(localOutputNode, localObject1);
      value.write(localOutputNode, localObject2);
    }
  }
  
  public Object read(InputNode paramInputNode)
  {
    Map localMap = (Map)factory.getInstance();
    if (localMap != null) {
      return read(paramInputNode, localMap);
    }
    return null;
  }
  
  public Object read(InputNode paramInputNode, Object paramObject)
  {
    paramObject = (Map)paramObject;
    if (paramObject != null) {
      return read(paramInputNode, (Map)paramObject);
    }
    return read(paramInputNode);
  }
  
  public boolean validate(InputNode paramInputNode)
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      if (!key.validate(paramInputNode)) {}
      while (!value.validate(paramInputNode)) {
        return false;
      }
      paramInputNode = localInputNode.getNext(str);
    }
    return true;
  }
  
  public void write(OutputNode paramOutputNode, Object paramObject)
  {
    OutputNode localOutputNode = paramOutputNode.getParent();
    Mode localMode = paramOutputNode.getMode();
    paramObject = (Map)paramObject;
    if (!paramOutputNode.isCommitted()) {
      paramOutputNode.remove();
    }
    write(localOutputNode, (Map)paramObject, localMode);
  }
}

/* Location:
 * Qualified Name:     org.simpleframework.xml.core.CompositeInlineMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */