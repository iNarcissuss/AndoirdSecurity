.class public Lae/gov/xmlhandler/CompanyQuotaHandler;
.super Lorg/xml/sax/helpers/DefaultHandler;
.source "CompanyQuotaHandler.java"


# instance fields
.field currentElement:Ljava/lang/Boolean;

.field currentValue:Ljava/lang/String;

.field private mArrayList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lae/gov/mol/vo/CompanyQuotaVo;",
            ">;"
        }
    .end annotation
.end field

.field mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Lorg/xml/sax/helpers/DefaultHandler;-><init>()V

    .line 18
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentElement:Ljava/lang/Boolean;

    .line 19
    const-string v0, ""

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    .line 20
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mArrayList:Ljava/util/ArrayList;

    .line 15
    return-void
.end method


# virtual methods
.method public characters([CII)V
    .locals 2
    .param p1, "ch"    # [C
    .param p2, "start"    # I
    .param p3, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 79
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentElement:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/String;

    invoke-direct {v0, p1, p2, p3}, Ljava/lang/String;-><init>([CII)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    .line 82
    :cond_0
    return-void
.end method

.method public endElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "localName"    # Ljava/lang/String;
    .param p3, "qName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 49
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentElement:Ljava/lang/Boolean;

    .line 51
    const-string v0, "comcode"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 52
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setComcode(Ljava/lang/String;)V

    .line 72
    :cond_0
    :goto_0
    return-void

    .line 54
    :cond_1
    const-string v0, "type_english"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 55
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setType_english(Ljava/lang/String;)V

    goto :goto_0

    .line 57
    :cond_2
    const-string v0, "type_arabic"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 58
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setType_arabic(Ljava/lang/String;)V

    goto :goto_0

    .line 60
    :cond_3
    const-string v0, "APPROVE"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 61
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setAPPROVE(Ljava/lang/String;)V

    goto :goto_0

    .line 63
    :cond_4
    const-string v0, "USED"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 64
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setUSED(Ljava/lang/String;)V

    goto :goto_0

    .line 65
    :cond_5
    const-string v0, "balance"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 66
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lae/gov/mol/vo/CompanyQuotaVo;->setBalance(Ljava/lang/String;)V

    goto :goto_0

    .line 68
    :cond_6
    const-string v0, "CompanyQuota"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mArrayList:Ljava/util/ArrayList;

    iget-object v1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getmArrayList()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lae/gov/mol/vo/CompanyQuotaVo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 25
    iget-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mArrayList:Ljava/util/ArrayList;

    return-object v0
.end method

.method public setmArrayList(Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lae/gov/mol/vo/CompanyQuotaVo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p1, "mArrayList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lae/gov/mol/vo/CompanyQuotaVo;>;"
    iput-object p1, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mArrayList:Ljava/util/ArrayList;

    .line 30
    return-void
.end method

.method public startElement(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/xml/sax/Attributes;)V
    .locals 1
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "localName"    # Ljava/lang/String;
    .param p3, "qName"    # Ljava/lang/String;
    .param p4, "attributes"    # Lorg/xml/sax/Attributes;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/xml/sax/SAXException;
        }
    .end annotation

    .prologue
    .line 37
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentElement:Ljava/lang/Boolean;

    .line 38
    const-string v0, ""

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->currentValue:Ljava/lang/String;

    .line 39
    const-string v0, "CompanyQuota"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 40
    new-instance v0, Lae/gov/mol/vo/CompanyQuotaVo;

    invoke-direct {v0}, Lae/gov/mol/vo/CompanyQuotaVo;-><init>()V

    iput-object v0, p0, Lae/gov/xmlhandler/CompanyQuotaHandler;->mCompanyQuotaVo:Lae/gov/mol/vo/CompanyQuotaVo;

    .line 42
    :cond_0
    return-void
.end method
