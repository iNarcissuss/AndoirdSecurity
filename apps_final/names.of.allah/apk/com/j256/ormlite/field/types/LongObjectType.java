package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

public class LongObjectType
  extends BaseDataType
{
  private static final LongObjectType singleTon = new LongObjectType();
  
  private LongObjectType()
  {
    super(SqlType.LONG, new Class[] { Long.class });
  }
  
  protected LongObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }
  
  public static LongObjectType getSingleton()
  {
    return singleTon;
  }
  
  public Object convertIdNumber(Number paramNumber)
  {
    return Long.valueOf(paramNumber.longValue());
  }
  
  public boolean isEscapedValue()
  {
    return false;
  }
  
  public boolean isValidForVersion()
  {
    return true;
  }
  
  public boolean isValidGeneratedType()
  {
    return true;
  }
  
  public Object moveToNextValue(Object paramObject)
  {
    if (paramObject == null) {
      return Long.valueOf(1L);
    }
    return Long.valueOf(((Long)paramObject).longValue() + 1L);
  }
  
  public Object parseDefaultString(FieldType paramFieldType, String paramString)
  {
    return Long.valueOf(Long.parseLong(paramString));
  }
  
  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
  {
    return Long.valueOf(paramDatabaseResults.getLong(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.j256.ormlite.field.types.LongObjectType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */