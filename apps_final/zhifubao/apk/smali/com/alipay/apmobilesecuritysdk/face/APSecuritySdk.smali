.class public Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
.super Ljava/lang/Object;


# static fields
.field private static a:Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;

.field private static b:Ljava/lang/Object;


# instance fields
.field private c:Landroid/content/Context;

.field private d:Ljava/lang/String;

.field private e:Z

.field private f:Z

.field private g:Ljava/lang/Thread;

.field private h:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->b:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->e:Z

    iput-boolean v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->f:Z

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->h:Ljava/util/LinkedList;

    iput-object p1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    return-void
.end method

.method static synthetic access$000(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/util/LinkedList;
    .locals 1

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->h:Ljava/util/LinkedList;

    return-object v0
.end method

.method static synthetic access$102(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Ljava/lang/Thread;)Ljava/lang/Thread;
    .locals 0

    iput-object p1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    return-object p1
.end method

.method static synthetic access$200(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Landroid/content/Context;
    .locals 1

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$300(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->f:Z

    return v0
.end method

.method static synthetic access$302(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->f:Z

    return p1
.end method

.method static synthetic access$400(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Z
    .locals 1

    iget-boolean v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->e:Z

    return v0
.end method

.method static synthetic access$402(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Z)Z
    .locals 0

    iput-boolean p1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->e:Z

    return p1
.end method

.method static synthetic access$500(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->d:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$502(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    iput-object p1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->d:Ljava/lang/String;

    return-object p1
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;
    .locals 2

    sget-object v1, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->a:Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;

    if-nez v0, :cond_0

    new-instance v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;

    invoke-direct {v0, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->a:Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;

    :cond_0
    sget-object v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->a:Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getUtdid(Landroid/content/Context;)Ljava/lang/String;
    .locals 6

    const-string/jumbo v1, ""

    :try_start_0
    const-string/jumbo v0, "com.ta.utdid2.device.UTDevice"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    const-string/jumbo v2, "getUtdid"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Class;

    const/4 v4, 0x0

    const-class v5, Landroid/content/Context;

    aput-object v5, v3, v4

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    const/4 v2, 0x0

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v0, v2, v3}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    move-object v0, v1

    goto :goto_0
.end method


# virtual methods
.method public getTokenResult()Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;
    .locals 2

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->d:Ljava/lang/String;

    invoke-static {v0}, Lcom/alipay/apmobilesecuritysdk/util/CommonUtils;->isBlank(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    invoke-static {v0}, Lcom/taobao/dp/DeviceSecuritySDK;->getInstance(Landroid/content/Context;)Lcom/taobao/dp/DeviceSecuritySDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/taobao/dp/DeviceSecuritySDK;->getSecurityToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->d:Ljava/lang/String;

    :cond_0
    new-instance v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;

    invoke-direct {v0, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V

    :try_start_0
    iget-object v1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    invoke-static {v1}, Lcom/alipay/apmobilesecuritysdk/apdid/ApdidManager;->getLocalApdid(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;->apdid:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    invoke-static {v1}, Lcom/alipay/apmobilesecuritysdk/apdid/ApdidManager;->getLocalApdidToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;->apdidToken:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->d:Ljava/lang/String;

    iput-object v1, v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;->umidToken:Ljava/lang/String;

    iget-object v1, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->c:Landroid/content/Context;

    invoke-static {v1}, Lcom/alipay/apmobilesecuritysdk/util/LocalRandomStr;->getRandomStr(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$TokenResult;->clientKey:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method public declared-synchronized initToken(ILjava/lang/String;Ljava/lang/String;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    .locals 9

    monitor-enter p0

    :try_start_0
    iget-object v8, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->h:Ljava/util/LinkedList;

    new-instance v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;

    const-string/jumbo v5, ""

    const/4 v7, 0x0

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v6, p4

    invoke-direct/range {v0 .. v7}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;Z)V

    invoke-virtual {v8, v0}, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$1;

    invoke-direct {v1, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$1;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    new-instance v1, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$2;

    invoke-direct {v1, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$2;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_0
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public initToken(ILjava/util/Map;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;",
            ")V"
        }
    .end annotation

    const-string/jumbo v0, "utdid"

    const-string/jumbo v1, ""

    invoke-static {p2, v0, v1}, Lcom/alipay/apmobilesecuritysdk/util/CommonUtils;->getValueFromMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v0, "tid"

    const-string/jumbo v1, ""

    invoke-static {p2, v0, v1}, Lcom/alipay/apmobilesecuritysdk/util/CommonUtils;->getValueFromMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v0, "userId"

    const-string/jumbo v1, ""

    invoke-static {p2, v0, v1}, Lcom/alipay/apmobilesecuritysdk/util/CommonUtils;->getValueFromMap(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    iget-object v8, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->h:Ljava/util/LinkedList;

    new-instance v0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;

    const/4 v7, 0x1

    move-object v1, p0

    move v2, p1

    move-object v6, p3

    invoke-direct/range {v0 .. v7}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$RunningTask;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$InitResultListener;Z)V

    invoke-virtual {v8, v0}, Ljava/util/LinkedList;->addLast(Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$3;

    invoke-direct {v1, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$3;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    iput-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    new-instance v1, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$4;

    invoke-direct {v1, p0}, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk$4;-><init>(Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;)V

    invoke-virtual {v0, v1}, Ljava/lang/Thread;->setUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    iget-object v0, p0, Lcom/alipay/apmobilesecuritysdk/face/APSecuritySdk;->g:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    :cond_0
    return-void
.end method
