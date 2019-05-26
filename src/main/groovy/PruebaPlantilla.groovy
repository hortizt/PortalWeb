package main.groovy
import static main.groovy.util.Plantillas.PlantillaPrinc
import main.groovy.util.DbUtilMQM

def peticion = DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION')

codigo = {
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

out<<PlantillaPrinc(codigo)


