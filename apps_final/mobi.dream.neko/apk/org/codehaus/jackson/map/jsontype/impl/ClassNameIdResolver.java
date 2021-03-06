package org.codehaus.jackson.map.jsontype.impl;

import java.util.EnumMap;
import java.util.EnumSet;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;
import org.codehaus.jackson.map.type.CollectionType;
import org.codehaus.jackson.map.type.MapType;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class ClassNameIdResolver
  extends TypeIdResolverBase
{
  public ClassNameIdResolver(JavaType paramJavaType, TypeFactory paramTypeFactory)
  {
    super(paramJavaType, paramTypeFactory);
  }
  
  protected final String _idFrom(Object paramObject, Class<?> paramClass)
  {
    Object localObject = paramClass;
    if (Enum.class.isAssignableFrom(paramClass))
    {
      localObject = paramClass;
      if (!paramClass.isEnum()) {
        localObject = paramClass.getSuperclass();
      }
    }
    paramClass = ((Class)localObject).getName();
    if (paramClass.startsWith("java.util")) {
      if ((paramObject instanceof EnumSet))
      {
        paramObject = ClassUtil.findEnumType((EnumSet)paramObject);
        paramObject = TypeFactory.defaultInstance().constructCollectionType(EnumSet.class, (Class)paramObject).toCanonical();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (String)paramObject;
              if ((paramObject instanceof EnumMap))
              {
                paramObject = ClassUtil.findEnumType((EnumMap)paramObject);
                return TypeFactory.defaultInstance().constructMapType(EnumMap.class, (Class)paramObject, Object.class).toCanonical();
              }
              localObject = paramClass.substring(9);
              if (((String)localObject).startsWith(".Arrays$")) {
                break;
              }
              paramObject = paramClass;
            } while (!((String)localObject).startsWith(".Collections$"));
            paramObject = paramClass;
          } while (paramClass.indexOf("List") < 0);
          return "java.util.ArrayList";
          paramObject = paramClass;
        } while (paramClass.indexOf('$') < 0);
        paramObject = paramClass;
      } while (ClassUtil.getOuterClass((Class)localObject) == null);
      paramObject = paramClass;
    } while (ClassUtil.getOuterClass(_baseType.getRawClass()) != null);
    return _baseType.getRawClass().getName();
  }
  
  public JsonTypeInfo.Id getMechanism()
  {
    return JsonTypeInfo.Id.CLASS;
  }
  
  public String idFromValue(Object paramObject)
  {
    return _idFrom(paramObject, paramObject.getClass());
  }
  
  public String idFromValueAndType(Object paramObject, Class<?> paramClass)
  {
    return _idFrom(paramObject, paramClass);
  }
  
  public void registerSubtype(Class<?> paramClass, String paramString) {}
  
  public JavaType typeFromId(String paramString)
  {
    if (paramString.indexOf('<') > 0) {
      return TypeFactory.fromCanonical(paramString);
    }
    try
    {
      Object localObject = ClassUtil.findClass(paramString);
      localObject = _typeFactory.constructSpecializedType(_baseType, (Class)localObject);
      return (JavaType)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): no such class found");
    }
    catch (Exception localException)
    {
      throw new IllegalArgumentException("Invalid type id '" + paramString + "' (for id type 'Id.class'): " + localException.getMessage(), localException);
    }
  }
}

/* Location:
 * Qualified Name:     org.codehaus.jackson.map.jsontype.impl.ClassNameIdResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */