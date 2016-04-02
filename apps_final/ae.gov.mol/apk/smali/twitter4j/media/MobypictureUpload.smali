.class Ltwitter4j/media/MobypictureUpload;
.super Ltwitter4j/media/AbstractImageUploadImpl;
.source "MobypictureUpload.java"


# direct methods
.method public constructor <init>(Ltwitter4j/conf/Configuration;Ljava/lang/String;Ltwitter4j/auth/OAuthAuthorization;)V
    .locals 0
    .param p1, "conf"    # Ltwitter4j/conf/Configuration;
    .param p2, "apiKey"    # Ljava/lang/String;
    .param p3, "oauth"    # Ltwitter4j/auth/OAuthAuthorization;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Ltwitter4j/media/AbstractImageUploadImpl;-><init>(Ltwitter4j/conf/Configuration;Ljava/lang/String;Ltwitter4j/auth/OAuthAuthorization;)V

    .line 35
    return-void
.end method


# virtual methods
.method protected postUpload()Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    .line 39
    iget-object v4, p0, Ltwitter4j/media/MobypictureUpload;->httpResponse:Ltwitter4j/internal/http/HttpResponse;

    invoke-virtual {v4}, Ltwitter4j/internal/http/HttpResponse;->getStatusCode()I

    move-result v3

    .line 40
    .local v3, "statusCode":I
    const/16 v4, 0xc8

    if-eq v3, v4, :cond_0

    .line 41
    new-instance v4, Ltwitter4j/TwitterException;

    const-string v5, "Mobypic image upload returned invalid status code"

    iget-object v6, p0, Ltwitter4j/media/MobypictureUpload;->httpResponse:Ltwitter4j/internal/http/HttpResponse;

    invoke-direct {v4, v5, v6}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ltwitter4j/internal/http/HttpResponse;)V

    throw v4

    .line 43
    :cond_0
    iget-object v4, p0, Ltwitter4j/media/MobypictureUpload;->httpResponse:Ltwitter4j/internal/http/HttpResponse;

    invoke-virtual {v4}, Ltwitter4j/internal/http/HttpResponse;->asString()Ljava/lang/String;

    move-result-object v2

    .line 46
    .local v2, "response":Ljava/lang/String;
    :try_start_0
    new-instance v1, Ltwitter4j/internal/org/json/JSONObject;

    invoke-direct {v1, v2}, Ltwitter4j/internal/org/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 47
    .local v1, "json":Ltwitter4j/internal/org/json/JSONObject;
    const-string v4, "media"

    invoke-virtual {v1, v4}, Ltwitter4j/internal/org/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 48
    const-string v4, "media"

    invoke-virtual {v1, v4}, Ltwitter4j/internal/org/json/JSONObject;->getJSONObject(Ljava/lang/String;)Ltwitter4j/internal/org/json/JSONObject;

    move-result-object v4

    const-string v5, "mediaurl"

    invoke-virtual {v4, v5}, Ltwitter4j/internal/org/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ltwitter4j/internal/org/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    return-object v4

    .line 50
    .end local v1    # "json":Ltwitter4j/internal/org/json/JSONObject;
    :catch_0
    move-exception v0

    .line 51
    .local v0, "e":Ltwitter4j/internal/org/json/JSONException;
    new-instance v4, Ltwitter4j/TwitterException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Invalid Mobypic response: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5, v0}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v4

    .line 54
    .end local v0    # "e":Ltwitter4j/internal/org/json/JSONException;
    .restart local v1    # "json":Ltwitter4j/internal/org/json/JSONObject;
    :cond_1
    new-instance v4, Ltwitter4j/TwitterException;

    const-string v5, "Unknown Mobypic response"

    iget-object v6, p0, Ltwitter4j/media/MobypictureUpload;->httpResponse:Ltwitter4j/internal/http/HttpResponse;

    invoke-direct {v4, v5, v6}, Ltwitter4j/TwitterException;-><init>(Ljava/lang/String;Ltwitter4j/internal/http/HttpResponse;)V

    throw v4
.end method

.method protected preUpload()V
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ltwitter4j/TwitterException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 59
    const-string v2, "https://api.mobypicture.com/2.0/upload.json"

    iput-object v2, p0, Ltwitter4j/media/MobypictureUpload;->uploadUrl:Ljava/lang/String;

    .line 60
    const-string v2, "https://api.twitter.com/1.1/account/verify_credentials.json"

    invoke-virtual {p0, v2}, Ltwitter4j/media/MobypictureUpload;->generateVerifyCredentialsAuthorizationHeader(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 62
    .local v1, "verifyCredentialsAuthorizationHeader":Ljava/lang/String;
    iget-object v2, p0, Ltwitter4j/media/MobypictureUpload;->headers:Ljava/util/Map;

    const-string v3, "X-Auth-Service-Provider"

    const-string v4, "https://api.twitter.com/1.1/account/verify_credentials.json"

    invoke-interface {v2, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 63
    iget-object v2, p0, Ltwitter4j/media/MobypictureUpload;->headers:Ljava/util/Map;

    const-string v3, "X-Verify-Credentials-Authorization"

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    iget-object v2, p0, Ltwitter4j/media/MobypictureUpload;->apiKey:Ljava/lang/String;

    if-nez v2, :cond_0

    .line 66
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "No API Key for Mobypic specified. put media.providerAPIKey in twitter4j.properties."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 68
    :cond_0
    const/4 v2, 0x2

    new-array v0, v2, [Ltwitter4j/internal/http/HttpParameter;

    new-instance v2, Ltwitter4j/internal/http/HttpParameter;

    const-string v3, "key"

    iget-object v4, p0, Ltwitter4j/media/MobypictureUpload;->apiKey:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Ltwitter4j/internal/http/HttpParameter;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    aput-object v2, v0, v5

    iget-object v2, p0, Ltwitter4j/media/MobypictureUpload;->image:Ltwitter4j/internal/http/HttpParameter;

    aput-object v2, v0, v6

    .line 71
    .local v0, "params":[Ltwitter4j/internal/http/HttpParameter;
    iget-object v2, p0, Ltwitter4j/media/MobypictureUpload;->message:Ltwitter4j/internal/http/HttpParameter;

    if-eqz v2, :cond_1

    .line 72
    new-array v2, v6, [Ltwitter4j/internal/http/HttpParameter;

    iget-object v3, p0, Ltwitter4j/media/MobypictureUpload;->message:Ltwitter4j/internal/http/HttpParameter;

    aput-object v3, v2, v5

    invoke-virtual {p0, v2, v0}, Ltwitter4j/media/MobypictureUpload;->appendHttpParameters([Ltwitter4j/internal/http/HttpParameter;[Ltwitter4j/internal/http/HttpParameter;)[Ltwitter4j/internal/http/HttpParameter;

    move-result-object v0

    .line 76
    :cond_1
    iput-object v0, p0, Ltwitter4j/media/MobypictureUpload;->postParameter:[Ltwitter4j/internal/http/HttpParameter;

    .line 77
    return-void
.end method
