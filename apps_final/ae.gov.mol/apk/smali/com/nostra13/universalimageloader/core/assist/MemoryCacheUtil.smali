.class public final Lcom/nostra13/universalimageloader/core/assist/MemoryCacheUtil;
.super Ljava/lang/Object;
.source "MemoryCacheUtil.java"


# static fields
.field private static final MEMORY_CACHE_KEY_FORMAT:Ljava/lang/String; = "%1$s_%2$dx%3$d"

.field private static final URI_AND_SIZE_SEPARATOR:Ljava/lang/String; = "_"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    return-void
.end method

.method public static createFuzzyKeyComparator()Ljava/util/Comparator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Comparator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    new-instance v0, Lcom/nostra13/universalimageloader/core/assist/MemoryCacheUtil$1;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/assist/MemoryCacheUtil$1;-><init>()V

    return-object v0
.end method

.method public static findCacheKeysForImageUri(Ljava/lang/String;Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;)Ljava/util/List;
    .locals 4
    .param p0, "imageUri"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 68
    .local p1, "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 69
    .local v2, "values":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->keys()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 70
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 71
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 74
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method public static findCachedBitmapsForImageUri(Ljava/lang/String;Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;)Ljava/util/List;
    .locals 4
    .param p0, "imageUri"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 53
    .local v2, "values":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Bitmap;>;"
    invoke-interface {p1}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->keys()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 54
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 55
    invoke-interface {p1, v1}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 58
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    return-object v2
.end method

.method public static generateKey(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/assist/ImageSize;)Ljava/lang/String;
    .locals 4
    .param p0, "imageUri"    # Ljava/lang/String;
    .param p1, "targetSize"    # Lcom/nostra13/universalimageloader/core/assist/ImageSize;

    .prologue
    .line 31
    const-string v0, "%1$s_%2$dx%3$d"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p1}, Lcom/nostra13/universalimageloader/core/assist/ImageSize;->getWidth()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-virtual {p1}, Lcom/nostra13/universalimageloader/core/assist/ImageSize;->getHeight()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static removeFromCache(Ljava/lang/String;Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;)V
    .locals 5
    .param p0, "imageUri"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 84
    .local p1, "memoryCache":Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;, "Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware<Ljava/lang/String;Landroid/graphics/Bitmap;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 85
    .local v3, "keysToRemove":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p1}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->keys()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 86
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v1, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 87
    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 90
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 91
    .local v2, "keyToRemove":Ljava/lang/String;
    invoke-interface {p1, v2}, Lcom/nostra13/universalimageloader/cache/memory/MemoryCacheAware;->remove(Ljava/lang/Object;)V

    goto :goto_1

    .line 93
    .end local v2    # "keyToRemove":Ljava/lang/String;
    :cond_2
    return-void
.end method
