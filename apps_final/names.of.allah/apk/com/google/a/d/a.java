package com.google.a.d;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class a
  implements Closeable
{
  private static final char[] b = ")]}'\n".toCharArray();
  public boolean a = false;
  private final Reader c;
  private final char[] d = new char['Ѐ'];
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  private long j;
  private int k;
  private String l;
  private int[] m = new int[32];
  private int n = 0;
  
  static
  {
    com.google.a.b.u.a = new b();
  }
  
  public a(Reader paramReader)
  {
    int[] arrayOfInt = m;
    int i1 = n;
    n = (i1 + 1);
    arrayOfInt[i1] = 6;
    if (paramReader == null) {
      throw new NullPointerException("in == null");
    }
    c = paramReader;
  }
  
  private IOException a(String paramString)
  {
    throw new e(paramString + " at line " + (g + 1) + " column " + t());
  }
  
  private void a(int paramInt)
  {
    if (n == m.length)
    {
      arrayOfInt = new int[n * 2];
      System.arraycopy(m, 0, arrayOfInt, 0, n);
      m = arrayOfInt;
    }
    int[] arrayOfInt = m;
    int i1 = n;
    n = (i1 + 1);
    arrayOfInt[i1] = paramInt;
  }
  
  private boolean a(char paramChar)
  {
    switch (paramChar)
    {
    default: 
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      u();
    }
    return false;
  }
  
  private int b(boolean paramBoolean)
  {
    char[] arrayOfChar = d;
    int i1 = e;
    int i2 = f;
    for (;;)
    {
      int i3 = i2;
      int i4 = i1;
      if (i1 == i2)
      {
        e = i1;
        if (b(1))
        {
          i4 = e;
          i3 = f;
        }
      }
      else
      {
        i1 = i4 + 1;
        i2 = arrayOfChar[i4];
        if (i2 == 10)
        {
          g += 1;
          h = i1;
          i2 = i3;
          continue;
        }
        if ((i2 == 32) || (i2 == 13) || (i2 == 9)) {
          break label482;
        }
        if (i2 == 47)
        {
          e = i1;
          if (i1 == i3)
          {
            e -= 1;
            boolean bool = b(2);
            e += 1;
            if (!bool) {
              return i2;
            }
          }
          u();
          switch (arrayOfChar[e])
          {
          default: 
            return i2;
          case '*': 
            e += 1;
            while ((e + "*/".length() <= f) || (b("*/".length()))) {
              if (d[e] == '\n')
              {
                g += 1;
                h = (e + 1);
                e += 1;
              }
              else
              {
                i1 = 0;
                for (;;)
                {
                  if (i1 >= "*/".length()) {
                    break label331;
                  }
                  if (d[(e + i1)] != "*/".charAt(i1)) {
                    break;
                  }
                  i1 += 1;
                }
              }
            }
            for (i1 = 1; i1 == 0; i1 = 0) {
              throw a("Unterminated comment");
            }
            i1 = e + 2;
            i2 = f;
            break;
          case '/': 
            label331:
            e += 1;
            v();
            i1 = e;
            i2 = f;
            break;
          }
        }
        if (i2 == 35)
        {
          e = i1;
          u();
          v();
          i1 = e;
          i2 = f;
          continue;
        }
        e = i1;
        return i2;
      }
      if (paramBoolean) {
        throw new EOFException("End of input at line " + (g + 1) + " column " + t());
      }
      return -1;
      label482:
      i2 = i3;
    }
  }
  
  private String b(char paramChar)
  {
    char[] arrayOfChar = d;
    StringBuilder localStringBuilder = new StringBuilder();
    label150:
    do
    {
      char c2 = e;
      int i1 = f;
      char c3;
      for (char c1 = c2;; c1 = c3)
      {
        if (c1 >= i1) {
          break label150;
        }
        c3 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          e = c3;
          localStringBuilder.append(arrayOfChar, c2, c3 - c2 - 1);
          return localStringBuilder.toString();
        }
        if (c1 == '\\')
        {
          e = c3;
          localStringBuilder.append(arrayOfChar, c2, c3 - c2 - 1);
          localStringBuilder.append(w());
          break;
        }
        if (c1 == '\n')
        {
          g += 1;
          h = c3;
        }
      }
      localStringBuilder.append(arrayOfChar, c2, c1 - c2);
      e = c1;
    } while (b(1));
    throw a("Unterminated string");
  }
  
  private boolean b(int paramInt)
  {
    boolean bool2 = false;
    char[] arrayOfChar = d;
    h -= e;
    if (f != e)
    {
      f -= e;
      System.arraycopy(arrayOfChar, e, arrayOfChar, 0, f);
    }
    for (;;)
    {
      e = 0;
      int i1;
      do
      {
        i1 = c.read(arrayOfChar, f, arrayOfChar.length - f);
        bool1 = bool2;
        if (i1 == -1) {
          break;
        }
        f = (i1 + f);
        i1 = paramInt;
        if (g == 0)
        {
          i1 = paramInt;
          if (h == 0)
          {
            i1 = paramInt;
            if (f > 0)
            {
              i1 = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                e += 1;
                h += 1;
                i1 = paramInt + 1;
              }
            }
          }
        }
        paramInt = i1;
      } while (f < i1);
      boolean bool1 = true;
      return bool1;
      f = 0;
    }
  }
  
  private void c(char paramChar)
  {
    char[] arrayOfChar = d;
    label91:
    do
    {
      char c1 = e;
      char c3 = f;
      for (;;)
      {
        if (c1 >= c3) {
          break label91;
        }
        char c2 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          e = c2;
          return;
        }
        if (c1 == '\\')
        {
          e = c2;
          w();
          break;
        }
        if (c1 == '\n')
        {
          g += 1;
          h = c2;
        }
        c1 = c2;
      }
      e = c1;
    } while (b(1));
    throw a("Unterminated string");
  }
  
  private int o()
  {
    int i2 = m[(n - 1)];
    int i1;
    if (i2 == 1)
    {
      m[(n - 1)] = 2;
      switch (b(true))
      {
      default: 
        e -= 1;
        if (n == 1) {
          u();
        }
        i1 = q();
        if (i1 == 0) {
          break;
        }
      }
    }
    label618:
    do
    {
      return i1;
      if (i2 == 2)
      {
        switch (b(true))
        {
        case 44: 
        default: 
          throw a("Unterminated array");
        case 93: 
          i = 4;
          return 4;
        }
        u();
        break;
      }
      if ((i2 == 3) || (i2 == 5))
      {
        m[(n - 1)] = 4;
        if (i2 == 5) {
          switch (b(true))
          {
          default: 
            throw a("Unterminated object");
          case 125: 
            i = 2;
            return 2;
          case 59: 
            u();
          }
        }
        i1 = b(true);
        switch (i1)
        {
        default: 
          u();
          e -= 1;
          if (a((char)i1))
          {
            i = 14;
            return 14;
          }
          break;
        case 34: 
          i = 13;
          return 13;
        case 39: 
          u();
          i = 12;
          return 12;
        case 125: 
          if (i2 != 5)
          {
            i = 2;
            return 2;
          }
          throw a("Expected name");
        }
        throw a("Expected name");
      }
      if (i2 == 4)
      {
        m[(n - 1)] = 5;
        switch (b(true))
        {
        case 58: 
        case 59: 
        case 60: 
        default: 
          throw a("Expected ':'");
        }
        u();
        if (((e >= f) && (!b(1))) || (d[e] != '>')) {
          break;
        }
        e += 1;
        break;
      }
      if (i2 == 6)
      {
        if (a)
        {
          b(true);
          e -= 1;
          if ((e + b.length <= f) || (b(b.length)))
          {
            i1 = 0;
            while (i1 < b.length)
            {
              if (d[(e + i1)] != b[i1]) {
                break label618;
              }
              i1 += 1;
            }
            e += b.length;
          }
        }
        m[(n - 1)] = 7;
        break;
      }
      if (i2 == 7)
      {
        if (b(false) == -1)
        {
          i = 17;
          return 17;
        }
        u();
        e -= 1;
        break;
      }
      if (i2 != 8) {
        break;
      }
      throw new IllegalStateException("JsonReader is closed");
      if (i2 == 1)
      {
        i = 4;
        return 4;
      }
      if ((i2 == 1) || (i2 == 2))
      {
        u();
        e -= 1;
        i = 7;
        return 7;
      }
      throw a("Unexpected value");
      u();
      i = 8;
      return 8;
      if (n == 1) {
        u();
      }
      i = 9;
      return 9;
      i = 3;
      return 3;
      i = 1;
      return 1;
      i2 = r();
      i1 = i2;
    } while (i2 != 0);
    if (!a(d[e])) {
      throw a("Expected value");
    }
    u();
    i = 10;
    return 10;
  }
  
  private int q()
  {
    int i1 = d[e];
    String str2;
    String str1;
    int i3;
    int i2;
    if ((i1 == 116) || (i1 == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i1 = 5;
      i3 = str2.length();
      i2 = 1;
    }
    for (;;)
    {
      if (i2 >= i3) {
        break label170;
      }
      if ((e + i2 >= f) && (!b(i2 + 1)))
      {
        return 0;
        if ((i1 == 102) || (i1 == 70))
        {
          str2 = "false";
          str1 = "FALSE";
          i1 = 6;
          break;
        }
        if ((i1 == 110) || (i1 == 78))
        {
          str2 = "null";
          str1 = "NULL";
          i1 = 7;
          break;
        }
        return 0;
      }
      int i4 = d[(e + i2)];
      if ((i4 != str2.charAt(i2)) && (i4 != str1.charAt(i2))) {
        return 0;
      }
      i2 += 1;
    }
    label170:
    if (((e + i3 < f) || (b(i3 + 1))) && (a(d[(e + i3)]))) {
      return 0;
    }
    e += i3;
    i = i1;
    return i1;
  }
  
  private int r()
  {
    char[] arrayOfChar = d;
    int i7 = e;
    int i5 = f;
    long l1 = 0L;
    int i1 = 0;
    int i2 = 1;
    int i3 = 0;
    int i4 = 0;
    int i8 = i5;
    int i6 = i8;
    i5 = i7;
    char c1;
    if (i7 + i4 == i8)
    {
      if (i4 == arrayOfChar.length) {
        return 0;
      }
      if (b(i4 + 1))
      {
        i5 = e;
        i6 = f;
      }
    }
    else
    {
      c1 = arrayOfChar[(i5 + i4)];
      switch (c1)
      {
      default: 
        if ((c1 < '0') || (c1 > '9'))
        {
          if (!a(c1)) {
            break label458;
          }
          return 0;
        }
        break;
      case '-': 
        if (i3 == 0)
        {
          i1 = 1;
          i3 = 1;
        }
        break;
      }
    }
    for (;;)
    {
      int i9 = i4 + 1;
      i4 = i3;
      i8 = i6;
      i7 = i5;
      i3 = i1;
      i1 = i4;
      i4 = i9;
      break;
      if (i3 == 5)
      {
        i7 = 6;
        i3 = i1;
        i1 = i7;
      }
      else
      {
        return 0;
        if (i3 == 5)
        {
          i7 = 6;
          i3 = i1;
          i1 = i7;
        }
        else
        {
          return 0;
          if ((i3 == 2) || (i3 == 4))
          {
            i7 = 5;
            i3 = i1;
            i1 = i7;
          }
          else
          {
            return 0;
            if (i3 == 2)
            {
              i7 = 3;
              i3 = i1;
              i1 = i7;
            }
            else
            {
              return 0;
              if ((i3 == 1) || (i3 == 0))
              {
                l1 = -(c1 - '0');
                i7 = 2;
                i3 = i1;
                i1 = i7;
              }
              else
              {
                if (i3 == 2)
                {
                  if (l1 == 0L) {
                    return 0;
                  }
                  long l2 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (i8 = 1;; i8 = 0)
                  {
                    i7 = i1;
                    l1 = l2;
                    i2 = i8 & i2;
                    i1 = i3;
                    i3 = i7;
                    break;
                  }
                }
                if (i3 == 3)
                {
                  i7 = 4;
                  i3 = i1;
                  i1 = i7;
                }
                else if ((i3 == 5) || (i3 == 6))
                {
                  i7 = 7;
                  i3 = i1;
                  i1 = i7;
                  continue;
                  label458:
                  if ((i3 == 2) && (i2 != 0) && ((l1 != Long.MIN_VALUE) || (i1 != 0)))
                  {
                    if (i1 != 0) {}
                    for (;;)
                    {
                      j = l1;
                      e += i4;
                      i = 15;
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i3 == 2) || (i3 == 4) || (i3 == 7))
                  {
                    k = i4;
                    i = 16;
                    return 16;
                  }
                  return 0;
                }
                else
                {
                  i7 = i1;
                  i1 = i3;
                  i3 = i7;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String s()
  {
    Object localObject1 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject2;
      int i2;
      if (e + i1 < f)
      {
        localObject2 = localObject1;
        i2 = i1;
        switch (d[(e + i1)])
        {
        default: 
          i1 += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          u();
          i2 = i1;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label188:
          if (localObject2 != null) {}
          break;
        }
      }
      else
      {
        for (localObject1 = new String(d, e, i2);; localObject1 = ((StringBuilder)localObject2).toString())
        {
          e = (i2 + e);
          return (String)localObject1;
          if (i1 < d.length)
          {
            localObject2 = localObject1;
            i2 = i1;
            if (!b(i1 + 1)) {
              break label188;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(d, e, i1);
          e = (i1 + e);
          if (b(1)) {
            break label325;
          }
          i2 = 0;
          break label188;
          ((StringBuilder)localObject2).append(d, e, i2);
        }
        label325:
        i1 = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private int t()
  {
    return e - h + 1;
  }
  
  private void u()
  {
    if (!a) {
      throw a("Use JsonReader.setLenient(true) to accept malformed JSON");
    }
  }
  
  private void v()
  {
    int i1;
    do
    {
      if ((e < f) || (b(1)))
      {
        char[] arrayOfChar = d;
        i1 = e;
        e = (i1 + 1);
        i1 = arrayOfChar[i1];
        if (i1 == 10)
        {
          g += 1;
          h = e;
        }
      }
      else
      {
        return;
      }
    } while (i1 != 13);
  }
  
  private char w()
  {
    if ((e == f) && (!b(1))) {
      throw a("Unterminated escape sequence");
    }
    char[] arrayOfChar = d;
    int i1 = e;
    e = (i1 + 1);
    char c1 = arrayOfChar[i1];
    switch (c1)
    {
    default: 
      return c1;
    case 'u': 
      if ((e + 4 > f) && (!b(4))) {
        throw a("Unterminated escape sequence");
      }
      int i2 = e;
      c1 = '\000';
      i1 = i2;
      if (i1 < i2 + 4)
      {
        int i3 = d[i1];
        int i4 = (char)(c1 << '\004');
        if ((i3 >= 48) && (i3 <= 57)) {
          c1 = (char)(i4 + (i3 - 48));
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((i3 >= 97) && (i3 <= 102))
          {
            c1 = (char)(i4 + (i3 - 97 + 10));
          }
          else
          {
            if ((i3 < 65) || (i3 > 70)) {
              break label270;
            }
            c1 = (char)(i4 + (i3 - 65 + 10));
          }
        }
        throw new NumberFormatException("\\u" + new String(d, e, 4));
      }
      e += 4;
      return c1;
    case 't': 
      return '\t';
    case 'b': 
      return '\b';
    case 'n': 
      return '\n';
    case 'r': 
      return '\r';
    case 'f': 
      label270:
      return '\f';
    }
    g += 1;
    h = e;
    return c1;
  }
  
  public void a()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 3)
    {
      a(1);
      i = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public final void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public void b()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 4)
    {
      n -= 1;
      i = 0;
      return;
    }
    throw new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public void c()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 1)
    {
      a(3);
      i = 0;
      return;
    }
    throw new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public void close()
  {
    i = 0;
    m[0] = 8;
    n = 1;
    c.close();
  }
  
  public void d()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 2)
    {
      n -= 1;
      i = 0;
      return;
    }
    throw new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public boolean e()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    return (i1 != 2) && (i1 != 4);
  }
  
  public c f()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    switch (i1)
    {
    default: 
      throw new AssertionError();
    case 1: 
      return c.c;
    case 2: 
      return c.d;
    case 3: 
      return c.a;
    case 4: 
      return c.b;
    case 12: 
    case 13: 
    case 14: 
      return c.e;
    case 5: 
    case 6: 
      return c.h;
    case 7: 
      return c.i;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      return c.f;
    case 15: 
    case 16: 
      return c.g;
    }
    return c.j;
  }
  
  public String g()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    String str;
    if (i1 == 14) {
      str = s();
    }
    for (;;)
    {
      i = 0;
      return str;
      if (i1 == 12)
      {
        str = b('\'');
      }
      else
      {
        if (i1 != 13) {
          break;
        }
        str = b('"');
      }
    }
    throw new IllegalStateException("Expected a name but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public String h()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    String str;
    if (i1 == 10) {
      str = s();
    }
    for (;;)
    {
      i = 0;
      return str;
      if (i1 == 8)
      {
        str = b('\'');
      }
      else if (i1 == 9)
      {
        str = b('"');
      }
      else if (i1 == 11)
      {
        str = l;
        l = null;
      }
      else if (i1 == 15)
      {
        str = Long.toString(j);
      }
      else
      {
        if (i1 != 16) {
          break;
        }
        str = new String(d, e, k);
        e += k;
      }
    }
    throw new IllegalStateException("Expected a string but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public boolean i()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 5)
    {
      i = 0;
      return true;
    }
    if (i1 == 6)
    {
      i = 0;
      return false;
    }
    throw new IllegalStateException("Expected a boolean but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public void j()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 7)
    {
      i = 0;
      return;
    }
    throw new IllegalStateException("Expected null but was " + f() + " at line " + (g + 1) + " column " + t());
  }
  
  public double k()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 15)
    {
      i = 0;
      return j;
    }
    if (i1 == 16)
    {
      l = new String(d, e, k);
      e += k;
    }
    double d1;
    do
    {
      for (;;)
      {
        i = 11;
        d1 = Double.parseDouble(l);
        if ((a) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1)))) {
          break label289;
        }
        throw new e("JSON forbids NaN and infinities: " + d1 + " at line " + (g + 1) + " column " + t());
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            l = b(c1);
            break;
          }
        }
        if (i1 != 10) {
          break;
        }
        l = s();
      }
    } while (i1 == 11);
    throw new IllegalStateException("Expected a double but was " + f() + " at line " + (g + 1) + " column " + t());
    label289:
    l = null;
    i = 0;
    return d1;
  }
  
  public long l()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 15)
    {
      i = 0;
      return j;
    }
    long l1;
    if (i1 == 16)
    {
      l = new String(d, e, k);
      e += k;
      i = 11;
      double d1 = Double.parseDouble(l);
      l1 = d1;
      if (l1 != d1) {
        throw new NumberFormatException("Expected a long but was " + l + " at line " + (g + 1) + " column " + t());
      }
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8) {}
        for (char c1 = '\'';; c1 = '"')
        {
          l = b(c1);
          try
          {
            l1 = Long.parseLong(l);
            i = 0;
            return l1;
          }
          catch (NumberFormatException localNumberFormatException) {}
          break;
        }
      }
      throw new IllegalStateException("Expected a long but was " + f() + " at line " + (g + 1) + " column " + t());
    }
    l = null;
    i = 0;
    return l1;
  }
  
  public int m()
  {
    int i2 = i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 15)
    {
      i1 = (int)j;
      if (j != i1) {
        throw new NumberFormatException("Expected an int but was " + j + " at line " + (g + 1) + " column " + t());
      }
      i = 0;
      return i1;
    }
    if (i1 == 16)
    {
      l = new String(d, e, k);
      e += k;
      i = 11;
      double d1 = Double.parseDouble(l);
      i1 = (int)d1;
      if (i1 != d1) {
        throw new NumberFormatException("Expected an int but was " + l + " at line " + (g + 1) + " column " + t());
      }
    }
    else
    {
      if ((i1 == 8) || (i1 == 9))
      {
        if (i1 == 8) {}
        for (char c1 = '\'';; c1 = '"')
        {
          l = b(c1);
          try
          {
            i1 = Integer.parseInt(l);
            i = 0;
            return i1;
          }
          catch (NumberFormatException localNumberFormatException) {}
          break;
        }
      }
      throw new IllegalStateException("Expected an int but was " + f() + " at line " + (g + 1) + " column " + t());
    }
    l = null;
    i = 0;
    return i1;
  }
  
  public void n()
  {
    int i2 = 0;
    int i1 = i;
    int i3 = i1;
    if (i1 == 0) {
      i3 = o();
    }
    if (i3 == 3)
    {
      a(1);
      i1 = i2 + 1;
    }
    for (;;)
    {
      label32:
      i = 0;
      i2 = i1;
      if (i1 != 0) {
        break;
      }
      return;
      if (i3 == 1)
      {
        a(3);
        i1 = i2 + 1;
      }
      else if (i3 == 4)
      {
        n -= 1;
        i1 = i2 - 1;
      }
      else if (i3 == 2)
      {
        n -= 1;
        i1 = i2 - 1;
      }
      else if ((i3 == 14) || (i3 == 10))
      {
        do
        {
          i1 = 0;
          for (;;)
          {
            if (e + i1 < f) {
              switch (d[(e + i1)])
              {
              default: 
                i1 += 1;
                break;
              case '#': 
              case '/': 
              case ';': 
              case '=': 
              case '\\': 
                u();
              case '\t': 
              case '\n': 
              case '\f': 
              case '\r': 
              case ' ': 
              case ',': 
              case ':': 
              case '[': 
              case ']': 
              case '{': 
              case '}': 
                e = (i1 + e);
                i1 = i2;
                break label32;
              }
            }
          }
          e = (i1 + e);
        } while (b(1));
        i1 = i2;
      }
      else if ((i3 == 8) || (i3 == 12))
      {
        c('\'');
        i1 = i2;
      }
      else if ((i3 == 9) || (i3 == 13))
      {
        c('"');
        i1 = i2;
      }
      else
      {
        i1 = i2;
        if (i3 == 16)
        {
          e += k;
          i1 = i2;
        }
      }
    }
  }
  
  public final boolean p()
  {
    return a;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + " at line " + (g + 1) + " column " + t();
  }
}

/* Location:
 * Qualified Name:     com.google.a.d.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */