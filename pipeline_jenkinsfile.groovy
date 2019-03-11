 def proyect_client = "${PROJECT_CLIENT}"
 def project_name = "${PROJECT_NAME}"

 // Variables locales (Propias de la clase)
 def url_git = "${URL_SCM}"
 String branch_scm = "${BRANCH_SCM}"
 def credentials_scm = "calidad.jenkins"

 folder(proyect_client) {
     description('Cliente ' + proyect_client)
 }

 folder(proyect_client + '/' + project_name) {
     description('Ambientes ' + project_name)
 }

 //-----------------------------------------Desarrollo--------------------------------------------

 folder(proyect_client + '/' + project_name + '/' + 'Desarrollo') {
     description('Ambiente Desarrollo')
 }

pipelineJob(proyect_client + '/' + project_name + '/' + 'Desarrollo' + '/' + project_name + '_Pipeline') {
    definition {
        cpsScm {
            scm {
                git(url_git)
                branch(branch_scm)
                //credentials(credentials_scm)
            }

            lightweight(true)
        }
    }
}
