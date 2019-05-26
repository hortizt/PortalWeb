package main.groovy


html.html {
    link(href:'//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css', rel:'stylesheet', id:'bootstrap-css')
    script(src:'//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js')
    script(src:'//code.jquery.com/jquery-1.11.1.min.js')
  head {
      title("Groovy Servlet")

  }
  body {

    div(class:'container') {
        div(class:'row') {
            div(class:"col-sm-3 col-md-3"){
                div(class:'panel-group', id:'accordion'){
                    div(class:"panel panel-default") {
                        div(class:"panel-heading"){
                            h4 ( class: "panel-title" ) {
                                span(class:"glyphicon glyphicon-folder-close")
                                a( "data-toggle":"collapse", dataparent:"#accordion" , href:"#collapseOne" ,"Seguimiento servicios") {

                                }
                            }
                        }
                        div(id:"collapseOne",class:"panel-collapse collapse"){
                            div(class:"panel-body"){
                                table(class:"table"){
                                    tr() {
                                        td() {
                                            span(class: "glyphicon glyphicon-pencil text-primary")
                                            a(href: "SeguimientoServicio.groovy", "Seguimiento num peticiones")
                                        }
                                    }
                                    tr() {
                                        td() {
                                            span(class: "glyphicon glyphicon-flash text-success")
                                            a(href: "SeguimientoServicio.groovy", "Seguimiento servicios")

                                        }
                                    }
                                }
                            }
                        }
                    }
                    div(class:"panel panel-default") {
                        div(class:"panel-heading"){
                            h4 ( class: "panel-title" ) {
                                span(class:"glyphicon glyphicon glyphicon-th")
                                a( datatoggle:"collapse", dataparent:"#accordion" , href:"#collapseOne" ,"Modules") {

                                }
                            }
                        }
                    }
                }
            }
            div(class:"col-sm-9 col-md-9"){
                div(class:"well"){
                    h1("Accordion Menu With Icon")

                }
            }
        }

    }

  }
}
