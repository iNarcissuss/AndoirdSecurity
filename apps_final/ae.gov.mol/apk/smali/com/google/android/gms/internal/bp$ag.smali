.class final Lcom/google/android/gms/internal/bp$ag;
.super Lcom/google/android/gms/internal/u$b;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/internal/bp;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "ag"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/u",
        "<",
        "Lcom/google/android/gms/internal/bu;",
        ">.b<",
        "Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic dE:Lcom/google/android/gms/internal/bp;

.field private final dU:Ljava/lang/String;

.field private final dV:I

.field private final p:I


# direct methods
.method constructor <init>(Lcom/google/android/gms/internal/bp;Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;IILjava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/bp$ag;->dE:Lcom/google/android/gms/internal/bp;

    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/internal/u$b;-><init>(Lcom/google/android/gms/internal/u;Ljava/lang/Object;)V

    iput p3, p0, Lcom/google/android/gms/internal/bp$ag;->p:I

    iput p4, p0, Lcom/google/android/gms/internal/bp$ag;->dV:I

    iput-object p5, p0, Lcom/google/android/gms/internal/bp$ag;->dU:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;)V
    .locals 3

    if-eqz p1, :cond_0

    iget v0, p0, Lcom/google/android/gms/internal/bp$ag;->p:I

    iget v1, p0, Lcom/google/android/gms/internal/bp$ag;->dV:I

    iget-object v2, p0, Lcom/google/android/gms/internal/bp$ag;->dU:Ljava/lang/String;

    invoke-interface {p1, v0, v1, v2}, Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;->onRealTimeMessageSent(IILjava/lang/String;)V

    :cond_0
    return-void
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;

    invoke-virtual {p0, p1}, Lcom/google/android/gms/internal/bp$ag;->a(Lcom/google/android/gms/games/multiplayer/realtime/RealTimeReliableMessageSentListener;)V

    return-void
.end method

.method protected d()V
    .locals 0

    return-void
.end method
