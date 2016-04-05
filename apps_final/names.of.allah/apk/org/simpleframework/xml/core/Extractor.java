package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

abstract interface Extractor<T extends Annotation>
{
  public abstract T[] getAnnotations();
  
  public abstract Label getLabel(T paramT);
  
  public abstract Class getType(T paramT);
}

/* Location:
 * Qualified Name:     org.simpleframework.xml.core.Extractor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */