.class Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_$3;
.super Ljava/lang/Object;
.source "AliUserLoginSetLoginPasswordActivity_.java"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$0:Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;


# direct methods
.method constructor <init>(Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;)V
    .locals 0

    .prologue
    .line 115
    iput-object p1, p0, Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_$3;->this$0:Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_$3;->this$0:Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;

    # invokes: Lcom/ali/user/mobile/password/PasswordActivity;->doRsa()V
    invoke-static {v0}, Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;->access$201(Lcom/ali/user/mobile/login/ui/AliUserLoginSetLoginPasswordActivity_;)V

    .line 121
    return-void
.end method
