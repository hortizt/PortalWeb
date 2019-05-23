package main.groovy.util
@Grab('org.hsqldb:hsqldb:2.3.2')
@GrabConfig(systemClassLoader=true)

import groovy.sql.Sql


class DbUtilMQM {
    def static user = 'sa'
    def static password = ''
    def static driver ='org.hsqldb.jdbcDriver'
    def static url = 'jdbc:hsqldb:mem:MQM'
    def static sql

    static init(){
        sql = Sql.newInstance(url, user, password, driver)
    }

    static create() {
        sql.close()
    }

    static bootStrap (){
        init()
        sql.execute '''
CREATE TABLE PS_PETICION(
PT_IDPETICION INTEGER, 
PT_IDSERVICIO INTEGER, 
PT_NUMPETICION INTEGER, 
PT_TIPOPETICION INTEGER, 
PT_ESTADOPETICION INTEGER, 
PT_ESTADOATIEMPO INTEGER, 
PT_CODIGOERROR VARCHAR(10), 
PT_MENSAJEERROR VARCHAR(400), 
PT_USER VARCHAR(30), 
PT_DESCRIPCION VARCHAR(100 ), 
PT_FECHACREACION date , 
PT_FECHAMODIFICACION date ) ;
     '''

    sql.execute '''
Insert into PS_PETICION (PT_IDPETICION,PT_IDSERVICIO,PT_NUMPETICION,PT_TIPOPETICION,PT_ESTADOPETICION,PT_ESTADOATIEMPO,PT_CODIGOERROR,PT_MENSAJEERROR,PT_USER,PT_DESCRIPCION,PT_FECHACREACION,PT_FECHAMODIFICACION) values 
(2004895,651123,904100920,1,18,null,0000,'Operacion OK',null,null,null,null);
    '''


    sql.execute '''
CREATE TABLE "PS_PETICIONDET" 
(
"PD_IDDETALLE" INTEGER, 
"PD_IDPETICION" INTEGER, 
"PD_INTERFACE" VARCHAR(40 ), 
"PD_PROCESO" VARCHAR(40 ) , 
"PD_SOURCE" VARCHAR(40 ) , 
"PD_DESTINO" VARCHAR(40 ) , 
"PD_ESTADOENVIO" INTEGER, 
"PD_MESSAGEID" VARCHAR(100 ), 
"PD_CORRELATIONID" VARCHAR(100 ), 
"PD_CODIGOERROR" VARCHAR(10 ), 
"PD_MENSAJEERROR" VARCHAR(400 ), 
"PD_USER" VARCHAR(30 ), 
"PD_FECHACREACION" date , 
"PD_FECHAMODIFICACION" date , 
"PD_MENSAJEXML" CLOB 
)  ;
     '''

        sql.execute '''
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699517','2004895','INT.SIGRES.CRM.001','PROC.HO.ADSL.SF.0100','CRM','SIGRES','1','X414d512054434f4c45534220202020205c7cd185202f9536','000000000000000000000000000000000000000000000000',null,null,null,null,null,'<sigres:Sigres xmlns:sigres="http://www.tid.es/Sigres" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"><sigres:SigresService><sigres:Interface>INT.SIGRES.CRM.001</sigres:Interface><sigres:Destination>SIGRES</sigres:Destination><sigres:Process>PROC.HO.ADSL.SF.0100</sigres:Process><sigres:Version>1.0</sigres:Version><sigres:Source>CRM</sigres:Source><sigres:Domain>CO</sigres:Domain></sigres:SigresService><sigres:ServiceFulfillment><sigres:ReserveResourceCreate><sigres:InputParameters><sigres:RequestNumber>904100920</sigres:RequestNumber><sigres:ResourceInformation><sigres:CustomerNumber>CC90000011</sigres:CustomerNumber><sigres:CustomerSegment>1</sigres:CustomerSegment><sigres:CustomerType>PERSONA NATURAL</sigres:CustomerType><sigres:ServiceType>2991</sigres:ServiceType><sigres:CreateType>1</sigres:CreateType><sigres:ServiceNumber>44100920</sigres:ServiceNumber><sigres:TerminalNumber>44100920</sigres:TerminalNumber><sigres:ConfirmationFlag>0</sigres:ConfirmationFlag><sigres:PssbaDataList><sigres:value name="client-document-number">90000011</sigres:value><sigres:value name="client-type">1</sigres:value><sigres:value name="client-document-type">1</sigres:value><sigres:value name="client-name">DIAZ DE LA CALLE JUAN JOSE</sigres:value><sigres:value name="client-first-lastname">-</sigres:value><sigres:value name="client-second-lastname">-</sigres:value><sigres:value name="code-name">73004000</sigres:value><sigres:value name="father-email">JJDLC</sigres:value></sigres:PssbaDataList><sigres:Other><sigres:value name="IPTV">false</sigres:value></sigres:Other><sigres:OLT><sigres:Code>CO_BOGO_BCHC_ALC_DSL_170135707</sigres:Code><sigres:Ip>10.37.20.242</sigres:Ip><sigres:Port>1</sigres:Port><sigres:Rack>1</sigres:Rack><sigres:SubRack>4</sigres:SubRack><sigres:board>1</sigres:board></sigres:OLT><sigres:ONT><sigres:Code>1</sigres:Code><sigres:Model>ONT_4_ETH_1_FXS</sigres:Model><sigres:Manufacturer>GENERICO</sigres:Manufacturer><sigres:Attenuation>1</sigres:Attenuation><sigres:Type>ONT_4_ETH_1_FXS</sigres:Type></sigres:ONT></sigres:ResourceInformation></sigres:InputParameters></sigres:ReserveResourceCreate></sigres:ServiceFulfillment></sigres:Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699518','2004895','INT.SIGRES.PSSBA.001','PROC.HO.ADSL.SF.0100','SIGRES','PSSBA','1','414d51205349475245532e484f2e514d5cacb5e72000374d','000000000000000000000000000000000000000000000000',null,null,null,CURRENT_DATE,null,'<Sigres><SigresService><Interface>INT.SIGRES.PSSBA.001</Interface><Destination>PSSBA</Destination><Process>PROC.HO.ADSL.SF.0100</Process><Version>1.0</Version><Source>SIGRES</Source><Domain>CO</Domain></SigresService><ServiceFulfillment><PSSBACreateAccount><InputParameters><RequestNumber>904100920</RequestNumber><CustomerId>CC90000011</CustomerId><ServiceNumber>44100920</ServiceNumber><PssbaData><NasPort>284852400</NasPort><NasIp>10.251.2.67</NasIp><NavPlan>2991</NavPlan><Speed>20480</Speed></PssbaData><PssbaDataList><value name="client-document-number">90000011</value><value name="client-type">1</value><value name="client-document-type">1</value><value name="client-name">DIAZ DE LA CALLE JUAN JOSE</value><value name="client-first-lastname">-</value><value name="client-second-lastname">-</value><value name="code-name">73004000</value><value name="father-email">JJDLC</value></PssbaDataList></InputParameters></PSSBACreateAccount></ServiceFulfillment></Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699519','2004895','INT.SIGRES.PSSBA.001','PROC.HO.ADSL.SF.0100','PSSBA','SIGRES','1','414d5120514d484354202020202020204714465b02999521','414d51205349475245532e484f2e514d5cacb5e72000374d','0001','La localidad ingresada no es válida.',null,CURRENT_DATE,null,'<Sigres><SigresService><Interface>INT.SIGRES.PSSBA.001</Interface><Destination>SIGRES</Destination><Process>PROC.HO.ADSL.SF.0100</Process><Version>1.0</Version><Source>PSSBA</Source><Domain>CO</Domain></SigresService><ServiceFulfillment><PSSBACreateAccount><OutputParameters><RequestNumber>904100920</RequestNumber><Error><Code>0001</Code><Description>La localidad ingresada no es válida.</Description></Error></OutputParameters></PSSBACreateAccount></ServiceFulfillment></Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699520','2004895','INT.SIGRES.CRM.004','PROC.HO.ADSL.SF.0100','SIGRES','CRM','1','414d51205349475245532e484f2e514d5cacb5e720003751','414d512054434f4c45534220202020205c7cd185202f9536','0008','Actividad manual pendiente en SIGRES por error en el PSSBA: La localidad ingresada no es vÃ¡lida.',null,CURRENT_DATE,null,'<si:Sigres xmlns:si="http://www.tid.es/Sigres"><si:SigresService><si:Interface>INT.SIGRES.CRM.004</si:Interface><si:Destination>CRM</si:Destination><si:Process>PROC.HO.ADSL.SF.0100</si:Process><si:Version>1.0</si:Version><si:Source>SIGRES</si:Source><si:Domain>CO</si:Domain></si:SigresService><si:ServiceFulfillment><si:ReserveConfirmation><si:OutputParameters><si:RequestNumber>904100920</si:RequestNumber><si:Error><si:Code>0008</si:Code><si:Description>Actividad manual pendiente en SIGRES por error en el PSSBA: La localidad ingresada no es vÃ?Â¡lida.</si:Description></si:Error></si:OutputParameters></si:ReserveConfirmation></si:ServiceFulfillment></si:Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699521','2004895','INT.SIGRES.SGOS.001','PROC.HO.ADSL.SF.0100','SIGRES','SGOS','1','414d51205349475245532e484f2e514d5cacb5e720003759','000000000000000000000000000000000000000000000000',null,null,null,CURRENT_DATE,null,'<si:Sigres xmlns:si="http://www.tid.es/Sigres"><si:SigresService><si:Interface>INT.SIGRES.SGOS.001</si:Interface><si:Destination>SGOS</si:Destination><si:Process>PROC.HO.ADSL.SF.0100</si:Process><si:Version>1.0</si:Version><si:Source>SIGRES</si:Source><si:Domain>CO</si:Domain></si:SigresService><si:ServiceFulfillment><si:ServiceOrderCreate><si:InputParameters><si:RequestNumber>904100920</si:RequestNumber><si:NetworkInformation><si:Equipment><si:Factory>HUAWEI TECHNOLOGIES</si:Factory><si:Type>DSLAM</si:Type><si:Model>MA5800T</si:Model><si:Location>CO_BOGO_AUTO</si:Location><si:Name>CO_BOGO_AUTO_170202354</si:Name><si:IP>10.37.20.242</si:IP><si:Rack>1</si:Rack><si:Subrack>4</si:Subrack><si:CardType>PON</si:CardType><si:Slot>1</si:Slot><si:PortId>01</si:PortId></si:Equipment><si:Atm><si:Client/><si:Net/><si:Modem/></si:Atm><si:Ont><si:Id>13</si:Id><si:Password>A0JYXGMYNF</si:Password><si:Vendor>GENERICO</si:Vendor><si:Model>ONT_4_ETH_1_FXS</si:Model><si:Profile>ONT_4_ETH_1_FXS/Speedy_10M</si:Profile></si:Ont><si:Profile><si:Adsl>Speedy_20M</si:Adsl><si:FTTXProfile><si:Type>SPEEDY</si:Type><si:LogicalPortName>10.37.20.242_1_4_1__1.13.2</si:LogicalPortName><si:GemPort>2</si:GemPort><si:VlanIdUser>100</si:VlanIdUser><si:SVlanId>4008</si:SVlanId><si:CVlanId>176</si:CVlanId><si:UpstreamProfile>Speedy_10M</si:UpstreamProfile><si:DownstreamProfile>Speedy_20M</si:DownstreamProfile><si:OntPorts>1</si:OntPorts></si:FTTXProfile><si:FTTXProfile><si:Type>VoIP</si:Type><si:LogicalPortName>10.37.20.242_1_4_1__1.13.1</si:LogicalPortName><si:GemPort>1</si:GemPort><si:TCont>1</si:TCont><si:VlanIdUser>101</si:VlanIdUser><si:SVlanId>3900</si:SVlanId><si:UpstreamProfile>Speedy_voip</si:UpstreamProfile><si:DownstreamProfile>Speedy_voip</si:DownstreamProfile><si:OntPorts>1</si:OntPorts></si:FTTXProfile></si:Profile><si:CodeElement>30763</si:CodeElement><si:ConfigurationStatus>SI</si:ConfigurationStatus><si:User>sigres</si:User><si:Password>t3l3c0n1c4#</si:Password><si:ServiceVlanID>4008</si:ServiceVlanID><si:UserVlanID>176</si:UserVlanID></si:NetworkInformation><si:RangeZoneId>OLT#10.37.20.242</si:RangeZoneId></si:InputParameters></si:ServiceOrderCreate></si:ServiceFulfillment></si:Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699522','2004895','INT.SIGRES.SGOS.002','PROC.HO.ADSL.SF.0100','SGOS','SIGRES','1','414d512054434f4c45534220202020205c7cd185202f953f','414d51205349475245532e484f2e514d5cacb5e720003759','0000','Operacion OK',null,CURRENT_DATE,null,'<Sigres><SigresService><Interface>INT.SIGRES.SGOS.002</Interface><Destination>SIGRES</Destination><Process>PROC.HO.ADSL.SF.0100</Process><Version>1.0</Version><Source>SGOS</Source><Domain>CO</Domain></SigresService><ServiceFulfillment><ServiceOrderCreate><OutputParameters><RequestNumber>904100920</RequestNumber><TicketNumber>904100920</TicketNumber><InstallationEndDate>2016-09-26 17:30:00.0</InstallationEndDate><Error><Code>0000</Code><Description>Operacion OK</Description></Error></OutputParameters></ServiceOrderCreate></ServiceFulfillment></Sigres>');
Insert into ps_peticiondet (PD_IDDETALLE,PD_IDPETICION,PD_INTERFACE,PD_PROCESO,PD_SOURCE,PD_DESTINO,PD_ESTADOENVIO,PD_MESSAGEID,PD_CORRELATIONID,PD_CODIGOERROR,PD_MENSAJEERROR,PD_USER,PD_FECHACREACION,PD_FECHAMODIFICACION,PD_MENSAJEXML) values ('5699523','2004895','INT.SIGRES.CRM.004','PROC.HO.ADSL.SF.0100','SIGRES','CRM','1','414d51205349475245532e484f2e514d5cacb5e72000375c','414d512054434f4c45534220202020205c7cd185202f9536','0000','Operacion OK',null,CURRENT_DATE,null,'<si:Sigres xmlns:si="http://www.tid.es/Sigres"><si:SigresService><si:Interface>INT.SIGRES.CRM.004</si:Interface><si:Destination>CRM</si:Destination><si:Process>PROC.HO.ADSL.SF.0100</si:Process><si:Version>1.0</si:Version><si:Source>SIGRES</si:Source><si:Domain>CO</si:Domain></si:SigresService><si:ServiceFulfillment><si:ReserveConfirmation><si:OutputParameters><si:RequestNumber>904100920</si:RequestNumber><si:TicketNumber>904100920</si:TicketNumber><si:InstallationEndDate>2016-09-26 17:30:00.0</si:InstallationEndDate><si:Error><si:Code>0000</si:Code><si:Description>Operacion OK</si:Description></si:Error></si:OutputParameters></si:ReserveConfirmation></si:ServiceFulfillment></si:Sigres>');
'''

        sql.execute '''
CREATE TABLE PS_CLIENTE
 (
"CL_IDCLIENTE" INTEGER,
"CL_NUMCLIENTE" VARCHAR(15), 
"CL_NOMBRES" VARCHAR(45), 
"CL_APELLIDOS" VARCHAR(45), 
"CL_DOCUMENTO" VARCHAR(15) , 
"CL_CODIGOLOCALIDAD" VARCHAR(10), 
"CL_TIPOCLIENTE" VARCHAR(20 ), 
"CL_SEGMENTO" INTEGER,
"CL_ESTADOCLIENTE" INTEGER,
"CL_USER" VARCHAR(30 ), 
"CL_FECHACREACION" date, 
"CL_FECHAMODIFICACION" date
   ); 
'''
          sql.execute '''
Insert into PS_CLIENTE (CL_IDCLIENTE,CL_NUMCLIENTE,CL_NOMBRES,CL_APELLIDOS,CL_DOCUMENTO,CL_CODIGOLOCALIDAD,CL_TIPOCLIENTE,CL_SEGMENTO,CL_ESTADOCLIENTE,CL_USER,CL_FECHACREACION,CL_FECHAMODIFICACION) 
values ('537188','CC90000011','DIAZ DE LA CALLE JUAN JOSE','-','90000011','73004000','PERSONA NATURAL','1','1',null,CURRENT_DATE,null);
'''



        sql.execute '''
CREATE TABLE "PS_SERVICIO" 
(
"SE_IDSERVICIO" INTEGER,
"SE_IDCLIENTE" INTEGER,
"SE_NUMSERVICIO" VARCHAR(10) , 
"SE_NUMTELEFONO" VARCHAR(10) , 
"SE_CODIGOSERVICIO" VARCHAR(100) , 
"SE_ZONAATENDIMIENTO" VARCHAR(250) , 
"SE_CANTIDADIP" VARCHAR(100), 
"SE_ESTADOSERVICIO" INTEGER,
"SE_USERNAME" VARCHAR(100), 
"SE_USER" VARCHAR(30), 
"SE_FECHACREACION" date, 
"SE_FECHAMODIFICACION" date
);
'''

        sql.execute '''
Insert into PS_SERVICIO (SE_IDSERVICIO,SE_IDCLIENTE,SE_NUMSERVICIO,SE_NUMTELEFONO,SE_CODIGOSERVICIO,SE_ZONAATENDIMIENTO,SE_CANTIDADIP,SE_ESTADOSERVICIO,SE_USERNAME,SE_USER,SE_FECHACREACION,SE_FECHAMODIFICACION) values 
('651123','537188','44100920','44100920','2991','OLT#10.37.20.242',null,'3','JJDLC',null,CURRENT_DATE,CURRENT_DATE);
'''
   sql.execute '''
CREATE TABLE "PS_DATOSAPROVISIONADO" 
(
"DA_IDSERVICIO"  INTEGER,
"DA_IPDSLAM" VARCHAR(20 ), 
"DA_FABRICA" VARCHAR(40 ), 
"DA_MODELO" VARCHAR(40 ), 
"DA_LOCALIZACION" VARCHAR(70 ), 
"DA_NOMBREDSLAM" VARCHAR(45 ), 
"DA_RACK"  INTEGER,
"DA_SUBRACK"  INTEGER,
"DA_TIPOTARJETA" VARCHAR(45 ), 
"DA_SLOT"  INTEGER,
"DA_PUERTO"  INTEGER, 
"DA_POTS" VARCHAR(10 ), 
"DA_ADSL" VARCHAR(10 ), 
"DA_IPLAN" VARCHAR(20 ), 
"DA_IPWAN" VARCHAR(20 ), 
"DA_IPMASK" VARCHAR(20 ), 
"DA_VPI" VARCHAR(10 ), 
"DA_VCI" VARCHAR(10 ), 
"DA_USER" VARCHAR(30 ), 
"DA_FECHACREACION" DATE, 
"DA_FECHAMODIFICACION" DATE
) ;
'''
        sql.execute '''
Insert into PS_DATOSAPROVISIONADO (DA_IDSERVICIO,DA_IPDSLAM,DA_FABRICA,DA_MODELO,DA_LOCALIZACION,DA_NOMBREDSLAM,DA_RACK,DA_SUBRACK,DA_TIPOTARJETA,DA_SLOT,DA_PUERTO,DA_POTS,DA_ADSL,DA_IPLAN,DA_IPWAN,DA_IPMASK,DA_VPI,DA_VCI,DA_USER,DA_FECHACREACION,DA_FECHAMODIFICACION) 
values ('651123','10.37.20.242','HUAWEI TECHNOLOGIES','MA5800T','CO_BOGO_AUTO','CO_BOGO_AUTO_170202354','1','4','PON','1','1',null,null,null,null,null,null,null,null,CURRENT_DATE,null);
'''
    }
}




class DbUtilInventario {
    def static user = 'sa'
    def static password = ''
    def static driver ='org.hsqldb.jdbcDriver'
    def static url = 'jdbc:hsqldb:mem:Inventario'
    def static sql

    static init(){
        sql = Sql.newInstance(url, user, password, driver)
    }

    static create() {
        sql.close()
    }

    static bootStrap (){
        init()
        sql.execute '''
CREATE TABLE "CONSULTA_DATOS_BA" 
(
"SERVICIO"        VARCHAR(255 ), 
"CLIENTE"         VARCHAR(50 ), 
"ESTADO_SER"      VARCHAR(255 ), 
"TELEFONO"        VARCHAR(50 ), 
"CTA_PADRE"       VARCHAR(4000 ), 
"PS"              VARCHAR(4000 ), 
"AB"              VARCHAR(45 ), 
"ZA"              VARCHAR(3100 ), 
"IP_DSLAM"        VARCHAR(30 ), 
"SHELF"           VARCHAR(12 ), 
"SLOT"            VARCHAR(30 ), 
"NOMBRE_PF"       VARCHAR(50 ), 
"PERFIL_PF"       VARCHAR(200 ), 
"PERFIL_ASSIA_PF" VARCHAR(200 ), 
"ESTADO_PF"       VARCHAR(20 ), 
"POTS"            VARCHAR(3100 ), 
"ADSL"            VARCHAR(3100 ), 
"IP_LAN"          VARCHAR(4000 ), 
"IP_WAN"          VARCHAR(4000 ), 
"MASCARA_IP"      VARCHAR(4000 )
) ;
'''
        sql.execute '''     
Insert into CONSULTA_DATOS_BA (SERVICIO,CLIENTE,ESTADO_SER,TELEFONO,CTA_PADRE,PS,AB,ZA,IP_DSLAM,SHELF,SLOT,NOMBRE_PF,PERFIL_PF,PERFIL_ASSIA_PF,ESTADO_PF,POTS,ADSL,IP_LAN,IP_WAN,MASCARA_IP) values ('004392532','CC7163548','EN SERVICIO','87432124','DGHS78','2085','2048 Kbps','TJ01','10.33.14.178','1','13','01','Speedy_2048','-','RESERVADO','10-1','10-1',' ',' ',' ');
'''
}
}