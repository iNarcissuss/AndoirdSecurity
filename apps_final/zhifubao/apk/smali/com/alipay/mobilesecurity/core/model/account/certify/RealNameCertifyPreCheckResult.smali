.class public Lcom/alipay/mobilesecurity/core/model/account/certify/RealNameCertifyPreCheckResult;
.super Lcom/alipay/mobilesecurity/common/service/model/MobileSecurityResult;

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field public canUpgradeACertify:Z

.field public logonId:Ljava/lang/String;

.field public occupyOverLimitFlag:Z

.field public occupyUserId:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/alipay/mobilesecurity/common/service/model/MobileSecurityResult;-><init>()V

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/alipay/mobilesecurity/core/model/account/certify/RealNameCertifyPreCheckResult;->occupyOverLimitFlag:Z

    return-void
.end method
