package main.groovy.util

class Plantillas {
    static PlantillaPrinc(sust)
    {
        def writer = new StringWriter()
        def html = new groovy.xml.MarkupBuilder(writer)
        html.html {
            head {
                title("Groovy Servlet")
                link(href: 'css/bootstrap.min.css', rel: 'stylesheet', media: 'screen')
            }
            body {
                div(class: 'container') {
                    h1("Varslinger")
                    div sust
                }
                script(src: 'http://code.jquery.com/jquery.js')
                script(src: 'js/bootstrap.min.js')
            }
        }
        writer.toString()
    }
}