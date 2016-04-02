.class Ltwitter4j/media/TwitterUpload;
.super Ljava/lang/Object;
.source "TwitterUpload.java"

# interfaces
.implements Ltwitter4j/media/ImageUpload;


# instance fields
.field private twitter:Ltwitter4j/Twitter;


# direct methods
.method public constructor <init>(Ltwitter4j/conf/Configuration;Ltwitter4j/auth/OAuthAuthorization;)V
    .locals 1
    .param p1, "conf"    # Ltwitter4j/conf/Configuration;
    .param p2, "oauth"    # Ltwitter4j/auth/OAuthAuthorization;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    new-instance v0, Ltwitter4j/TwitterFactory;

    invoke-direct {v0, p1}, Ltwitter4j/TwitterFactory;-><init>(Ltwitter4j/conf/Configuration;)V

    invoke-virtual {v0, p2}, Ltwitter4j/TwitterFactory;->getInstance(Ltwitter4j/auth/Authorization;)Ltwitter4j/Twitter;

    move-result-object v0

    iput-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    .line 38
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 62
    if-ne p0, p1, :cond_1

    .line 69
    :cond_0
    :goto_0
    return v1

    .line 63
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 65
    check-cast v0, Ltwitter4j/media/TwitterUpload;

    .line 67
    .local v0, "that":Ltwitter4j/media/TwitterUpload;
    iget-object v3, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    if-eqz v3, :cond_4

    iget-object v3, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    iget-object v4, v0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    goto :goto_0

    :cond_4
    iget-object v3, v0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 79
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TwitterUpload{twitter="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public upload(Ljava/io/File;)Ljava/lang/String;
    .locals 3
    .param p1, "image"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 47
    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    new-instance v1, Ltwitter4j/StatusUpdate;

    const-string v2, ""

    invoke-direct {v1, v2}, Ltwitter4j/StatusUpdate;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ltwitter4j/StatusUpdate;->media(Ljava/io/File;)Ltwitter4j/StatusUpdate;

    move-result-object v1

    invoke-interface {v0, v1}, Ltwitter4j/Twitter;->updateStatus(Ltwitter4j/StatusUpdate;)Ltwitter4j/Status;

    move-result-object v0

    invoke-interface {v0}, Ltwitter4j/Status;->getText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public upload(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "image"    # Ljava/io/File;
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 42
    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    new-instance v1, Ltwitter4j/StatusUpdate;

    invoke-direct {v1, p2}, Ltwitter4j/StatusUpdate;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ltwitter4j/StatusUpdate;->media(Ljava/io/File;)Ltwitter4j/StatusUpdate;

    move-result-object v1

    invoke-interface {v0, v1}, Ltwitter4j/Twitter;->updateStatus(Ltwitter4j/StatusUpdate;)Ltwitter4j/Status;

    move-result-object v0

    invoke-interface {v0}, Ltwitter4j/Status;->getText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public upload(Ljava/lang/String;Ljava/io/InputStream;)Ljava/lang/String;
    .locals 3
    .param p1, "imageFileName"    # Ljava/lang/String;
    .param p2, "imageBody"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 52
    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    new-instance v1, Ltwitter4j/StatusUpdate;

    const-string v2, ""

    invoke-direct {v1, v2}, Ltwitter4j/StatusUpdate;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ltwitter4j/StatusUpdate;->media(Ljava/lang/String;Ljava/io/InputStream;)Ltwitter4j/StatusUpdate;

    move-result-object v1

    invoke-interface {v0, v1}, Ltwitter4j/Twitter;->updateStatus(Ltwitter4j/StatusUpdate;)Ltwitter4j/Status;

    move-result-object v0

    invoke-interface {v0}, Ltwitter4j/Status;->getText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public upload(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "imageFileName"    # Ljava/lang/String;
    .param p2, "imageBody"    # Ljava/io/InputStream;
    .param p3, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Ltwitter4j/media/TwitterUpload;->twitter:Ltwitter4j/Twitter;

    new-instance v1, Ltwitter4j/StatusUpdate;

    invoke-direct {v1, p3}, Ltwitter4j/StatusUpdate;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1, p2}, Ltwitter4j/StatusUpdate;->media(Ljava/lang/String;Ljava/io/InputStream;)Ltwitter4j/StatusUpdate;

    move-result-object v1

    invoke-interface {v0, v1}, Ltwitter4j/Twitter;->updateStatus(Ltwitter4j/StatusUpdate;)Ltwitter4j/Status;

    move-result-object v0

    invoke-interface {v0}, Ltwitter4j/Status;->getText()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
