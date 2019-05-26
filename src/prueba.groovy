import main.groovy.util.DbUtilMQM

DbUtilMQM.bootStrap()
assert DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION').size() ==1

def peticion = DbUtilMQM.sql.rows('SELECT * FROM PS_PETICION')

println peticion
