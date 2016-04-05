package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

final class BitMatrixParser
{
  private final BitMatrix bitMatrix;
  private FormatInformation parsedFormatInfo;
  private Version parsedVersion;
  
  BitMatrixParser(BitMatrix paramBitMatrix)
    throws FormatException
  {
    int i = paramBitMatrix.getHeight();
    if ((i < 21) || ((i & 0x3) != 1)) {
      throw FormatException.getFormatInstance();
    }
    bitMatrix = paramBitMatrix;
  }
  
  private int copyBit(int paramInt1, int paramInt2, int paramInt3)
  {
    if (bitMatrix.get(paramInt1, paramInt2)) {
      return paramInt3 << 1 | 0x1;
    }
    return paramInt3 << 1;
  }
  
  byte[] readCodewords()
    throws FormatException
  {
    Object localObject = readFormatInformation();
    Version localVersion = readVersion();
    localObject = DataMask.forReference(((FormatInformation)localObject).getDataMask());
    int i6 = bitMatrix.getHeight();
    ((DataMask)localObject).unmaskBitMatrix(bitMatrix, i6);
    localObject = localVersion.buildFunctionPattern();
    int i2 = 1;
    byte[] arrayOfByte = new byte[localVersion.getTotalCodewords()];
    int i = 0;
    int k = 0;
    int m = 0;
    int j = i6 - 1;
    int i3;
    label92:
    int i4;
    label113:
    int i5;
    label116:
    int i1;
    int n;
    if (j > 0)
    {
      i3 = j;
      if (j == 6) {
        i3 = j - 1;
      }
      j = 0;
      if (j < i6) {
        if (i2 != 0)
        {
          i4 = i6 - 1 - j;
          i5 = 0;
          if (i5 >= 2) {
            break label241;
          }
          i1 = m;
          n = k;
          if (((BitMatrix)localObject).get(i3 - i5, i4)) {
            break label280;
          }
          m += 1;
          n = k << 1;
          k = n;
          if (bitMatrix.get(i3 - i5, i4)) {
            k = n | 0x1;
          }
          i1 = m;
          n = k;
          if (m != 8) {
            break label280;
          }
          m = i + 1;
          arrayOfByte[i] = ((byte)k);
          n = 0;
          k = 0;
          i = m;
          m = n;
        }
      }
    }
    for (;;)
    {
      i5 += 1;
      break label116;
      i4 = j;
      break label113;
      label241:
      j += 1;
      break label92;
      i2 ^= 0x1;
      j = i3 - 2;
      break;
      if (i != localVersion.getTotalCodewords()) {
        throw FormatException.getFormatInstance();
      }
      return arrayOfByte;
      label280:
      m = i1;
      k = n;
    }
  }
  
  FormatInformation readFormatInformation()
    throws FormatException
  {
    if (parsedFormatInfo != null) {
      return parsedFormatInfo;
    }
    int j = 0;
    int i = 0;
    while (i < 6)
    {
      j = copyBit(i, 8, j);
      i += 1;
    }
    j = copyBit(8, 7, copyBit(8, 8, copyBit(7, 8, j)));
    i = 5;
    while (i >= 0)
    {
      j = copyBit(8, i, j);
      i -= 1;
    }
    int m = bitMatrix.getHeight();
    i = 0;
    int k = m - 1;
    while (k >= m - 7)
    {
      i = copyBit(8, k, i);
      k -= 1;
    }
    k = m - 8;
    while (k < m)
    {
      i = copyBit(k, 8, i);
      k += 1;
    }
    parsedFormatInfo = FormatInformation.decodeFormatInformation(j, i);
    if (parsedFormatInfo != null) {
      return parsedFormatInfo;
    }
    throw FormatException.getFormatInstance();
  }
  
  Version readVersion()
    throws FormatException
  {
    if (parsedVersion != null) {
      return parsedVersion;
    }
    int m = bitMatrix.getHeight();
    int i = m - 17 >> 2;
    if (i <= 6) {
      return Version.getVersionForNumber(i);
    }
    int j = 0;
    int n = m - 11;
    i = 5;
    int k;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = copyBit(k, i, j);
        k -= 1;
      }
      i -= 1;
    }
    Version localVersion = Version.decodeVersionInformation(j);
    if ((localVersion != null) && (localVersion.getDimensionForVersion() == m))
    {
      parsedVersion = localVersion;
      return localVersion;
    }
    j = 0;
    i = 5;
    while (i >= 0)
    {
      k = m - 9;
      while (k >= n)
      {
        j = copyBit(i, k, j);
        k -= 1;
      }
      i -= 1;
    }
    localVersion = Version.decodeVersionInformation(j);
    if ((localVersion != null) && (localVersion.getDimensionForVersion() == m))
    {
      parsedVersion = localVersion;
      return localVersion;
    }
    throw FormatException.getFormatInstance();
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.decoder.BitMatrixParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */