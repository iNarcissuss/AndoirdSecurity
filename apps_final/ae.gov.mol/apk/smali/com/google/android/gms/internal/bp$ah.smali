.class final Lcom/google/android/gms/internal/bp$ah;
.super Lcom/google/android/gms/internal/bo;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/bp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ah"
.end annotation


# instance fields
.field final synthetic dE:Lcom/google/android/gms/internal/bp;

.field final dW:Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/bp;Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/bp$ah;->dE:Lcom/google/android/gms/internal/bp;

    invoke-direct {p0}, Lcom/google/android/gms/internal/bo;-><init>()V

    iput-object p2, p0, Lcom/google/android/gms/internal/bp$ah;->dW:Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;

    return-void
.end method


# virtual methods
.method public a(IILjava/lang/String;)V
    .locals 7

    iget-object v6, p0, Lcom/google/android/gms/internal/bp$ah;->dE:Lcom/google/android/gms/internal/bp;

    new-instance v0, Lcom/google/android/gms/internal/bp$ag;

    iget-object v1, p0, Lcom/google/android/gms/internal/bp$ah;->dE:Lcom/google/android/gms/internal/bp;

    iget-object v2, p0, Lcom/google/android/gms/internal/bp$ah;->dW:Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;

    move v3, p1

    move v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/bp$ag;-><init>(Lcom/google/android/gms/internal/bp;Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;IILjava/lang/String;)V

    invoke-virtual {v6, v0}, Lcom/google/android/gms/internal/bp;->a(Lcom/google/android/gms/internal/u$b;)V

    return-void
.end method
