package main.groovy.back

import main.groovy.util.DbUtilMQM

def peticion = DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION')

html.html {
  head {
      title("Groovy Servlet")
      link(href:'css/bootstrap.min.css', rel:'stylesheet', media:'screen')
  }
  body {
    div(class:'container') {
      h1("Varslinger")
      table(class:'table table-striped') {
          thead {
              tr {
                  th("PT_IDPETICION")
                  th("PT_IDSERVICIO")
                  th("PT_MENSAJEERROR")
              }
          }
          tbody {

                  peticion.each { pet ->
                      tr {
                          td(pet["PT_IDPETICION"])
                          td(pet["PT_IDSERVICIO"])
                          td(pet["PT_MENSAJEERROR"])
                  }

              }

          }
      }
    }
    script(src:'http://code.jquery.com/jquery.js')
    script(src:'js/bootstrap.min.js')
  }
}
