<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>README - ApodFlow</title>
</head>
<body>
    <h1>ApodFlow - Projeto Android</h1>
    <p>Este projeto é um aplicativo Android desenvolvido para ApodFlow, com o objetivo de fornecer funcionalidades de compartilhamento e download de imagens relacionadas ao "Astronomy Picture of the Day" (APOD) da NASA.</p>

    <h2>Requisitos</h2>
    <ul>
        <li>Android Studio (última versão recomendada).</li>
        <li>JDK 8 ou superior.</li>
        <li>SDK do Android (versão 29 ou superior).</li>
        <li>Emulador Android ou dispositivo físico Android.</li>
    </ul>

    <h2>Passos para Rodar o Projeto</h2>
    <h3>1. Instalar o Android Studio</h3>
    <p>Baixe e instale o Android Studio, que é o ambiente de desenvolvimento oficial para criar aplicativos Android. Siga os passos descritos no site oficial para o sistema operacional do seu computador:</p>
    <p><a href="https://developer.android.com/studio">Baixar Android Studio</a></p>

    <h3>2. Criar um Novo Projeto no Android Studio</h3>
    <ol>
        <li>Abrir o Android Studio.</li>
        <li>Na tela inicial, clique em "Start a new Android Studio project".</li>
        <li>Escolha o template "Empty Activity".</li>
        <li>Defina o nome do projeto como ApodFlow (ou o nome que você preferir).</li>
        <li>Defina o Package name como <code>com.example.apodflow</code>.</li>
        <li>Defina o Language como Java.</li>
        <li>Escolha o Minimum SDK como API 29 (ou superior).</li>
        <li>Clique em Finish.</li>
    </ol>

    <h3>3. Adicionar os Arquivos ao Projeto</h3>
    <p>Para adicionar os seus arquivos ao projeto, siga os passos abaixo:</p>
    <ul>
        <li>Copie todos os arquivos da pasta <code>app/src/main/</code> do seu projeto anterior (onde você já tem o código pronto) para a mesma pasta no novo projeto.</li>
        <li>Verifique se todos os arquivos de layout, imagens e recursos estão nas pastas corretas (por exemplo, em <code>res/layout/</code> e <code>res/drawable/</code>).</li>
    </ul>

    <h3>4. Verificar e Ajustar o Código</h3>
    <p>Verifique o código do seu projeto, principalmente os seguintes pontos:</p>
    <ul>
        <li><b>Permissões no AndroidManifest.xml:</b> Se o seu projeto faz uso de permissões, como acessar a internet ou gravar arquivos no armazenamento, adicione as permissões necessárias no arquivo <code>AndroidManifest.xml</code>.</li>
        <li><b>Dependências no build.gradle:</b> Se o seu projeto usa bibliotecas externas (como Retrofit ou Glide), elas devem ser adicionadas no arquivo <code>build.gradle</code>.</li>
    </ul>

    <h3>5. Adicionar Dependências</h3>
    <p>As dependências são bibliotecas de terceiros que o projeto usa. Para adicionar as dependências, abra o arquivo <code>build.gradle (Module: app)</code>, localizado em <code>app/build.gradle</code> e adicione as dependências na seção <code>dependencies</code> conforme mostrado abaixo:</p>
    <pre><code>
dependencies {
    // Bibliotecas de interface
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    
    // Bibliotecas de teste
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    
    // Bibliotecas de redes e imagens
    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
}
    </code></pre>
    <p>Após adicionar as dependências, clique em "Sync Now" no topo da tela para baixar e integrar essas bibliotecas ao seu projeto.</p>

    <h3>6. Rodar o Projeto no Emulador ou Dispositivo Físico</h3>
    <h4>Rodar no Emulador:</h4>
    <ol>
        <li>No Android Studio, clique no ícone de Play (triângulo verde).</li>
        <li>Caso ainda não tenha um emulador configurado, clique em "Create New Virtual Device" e siga as instruções para configurar um dispositivo virtual.</li>
        <li>Selecione o emulador e clique em "Run".</li>
    </ol>
    
    <h4>Rodar no Celular:</h4>
    <ol>
        <li>Conecte seu celular via cabo USB ao computador.</li>
        <li>Ative a Depuração USB nas Opções de Desenvolvedor do seu dispositivo Android.</li>
        <li>Clique em "Run" (triângulo verde) e selecione o seu dispositivo na lista que aparecerá.</li>
    </ol>

    <h2>Estrutura do Projeto</h2>
    <pre><code>
ApodFlow/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/apodflow/  <-- Código Java
│   │   │   ├── res/
│   │   │   │   ├── layout/                 <-- Layouts XML
│   │   │   │   ├── drawable/               <-- Imagens
│   │   │   │   └── values/                 <-- Cores, strings, dimensões, etc.
│   │   │   ├── AndroidManifest.xml         <-- Definições do aplicativo
│   │   ├── build.gradle                    <-- Dependências e configurações do projeto
│
└── build.gradle                            <-- Dependências de nível superior
    </code></pre>

    <h2>Como Rodar o Projeto</h2>
    <h3>Via Emulador:</h3>
    <p>Configure o emulador e inicie o projeto clicando no ícone Play no Android Studio.</p>
    <h3>Via Dispositivo Físico:</h3>
    <p>Conecte seu celular via USB, ative a depuração e selecione o dispositivo para rodar o projeto.</p>

    <h2>Dúvidas e Contribuições</h2>
    <p>Se você encontrar algum erro ou tiver sugestões para melhorar o projeto, sinta-se à vontade para abrir uma issue ou enviar um pull request.</p>

    <h2>Exibição do Projeto</h2>
    <p>Abaixo estão imagens do projeto rodando:</p>
    <div>
        <h3>Imagem 1</h3>
        <img src="caminho/para/imagem1.jpg" alt="Imagem 1 do projeto">
    </div>
    <div>
        <h3>Imagem 2</h3>
        <img src="caminho/para/imagem2.jpg" alt="Imagem 2 do projeto">
    </div>

    <hr>

    <h1>ApodFlow - Android Project</h1>
    <p>This project is an Android application developed for ApodFlow, aiming to provide functionalities for sharing and downloading images related to NASA's Astronomy Picture of the Day (APOD).</p>

    <h2>Requirements</h2>
    <ul>
        <li>Android Studio (latest recommended version).</li>
        <li>JDK 8 or higher.</li>
        <li>Android SDK (version 29 or higher).</li>
        <li>Android Emulator or physical Android device.</li>
    </ul>

    <h2>Steps to Run the Project</h2>
    <h3>1. Install Android Studio</h3>
    <p>Download and install Android Studio, the official development environment for creating Android apps. Follow the steps described on the official website for your operating system:</p>
    <p><a href="https://developer.android.com/studio">Download Android Studio</a></p>

    <h3>2. Create a New Project in Android Studio</h3>
    <ol>
        <li>Open Android Studio.</li>
        <li>On the welcome screen, click "Start a new Android Studio project".</li>
        <li>Choose the "Empty Activity" template.</li>
        <li>Set the project name to ApodFlow (or your preferred name).</li>
        <li>Set the Package name to <code>com.example.apodflow</code>.</li>
        <li>Set the Language to Java.</li>
        <li>Choose the Minimum SDK as API 29 (or higher).</li>
        <li>Click Finish.</li>
    </ol>

    <h3>3. Add Files to the Project</h3>
    <p>To add your files to the project, follow these steps:</p>
    <ul>
        <li>Copy all the files from the <code>app/src/main/</code> folder of your previous project (where you already have the code) to the same folder in the new project.</li>
        <li>Make sure all the layout files, images, and resources are in the correct folders (e.g., in <code>res/layout/</code> and <code>res/drawable/</code>).</li>
    </ul>

    <h3>4. Check and Adjust the Code</h3>
    <p>Check your project's code, especially the following:</p>
    <ul>
        <li><b>Permissions in AndroidManifest.xml:</b> If your project uses permissions like accessing the internet or writing to storage, add the necessary permissions in the <code>AndroidManifest.xml</code> file.</li>
        <li><b>Dependencies in build.gradle:</b> If your project uses external libraries (such as Retrofit or Glide), they should be added to the <code>build.gradle</code> file.</li>
    </ul>

    <h3>5. Add Dependencies</h3>
    <p>Dependencies are third-party libraries the project uses. To add dependencies, open the <code>build.gradle (Module: app)</code> file, located in <code>app/build.gradle</code>, and add the dependencies in the <code>dependencies</code> section as shown below:</p>
    <pre><code>
dependencies {
    // Interface libraries
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    
    // Test libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    
    // Network and image libraries
    implementation("com.squareup.retrofit2:retrofit:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.4.0")
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")
}
    </code></pre>
    <p>After adding the dependencies, click "Sync Now" at the top to download and integrate these libraries into your project.</p>

    <h3>6. Run the Project on Emulator or Physical Device</h3>
    <h4>Run on Emulator:</h4>
    <ol>
        <li>In Android Studio, click the Play icon (green triangle).</li>
        <li>If you don't have an emulator configured yet, click "Create New Virtual Device" and follow the instructions to set up a virtual device.</li>
        <li>Select the emulator and click "Run".</li>
    </ol>
    
    <h4>Run on Mobile:</h4>
    <ol>
        <li>Connect your mobile via USB to the computer.</li>
        <li>Enable USB Debugging in your Android device's Developer Options.</li>
        <li>Click "Run" (green triangle) and select your device from the list that appears.</li>
    </ol>

    <h2>Project Structure</h2>
    <pre><code>
ApodFlow/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/example/apodflow/  <-- Java Code
│   │   │   ├── res/
│   │   │   │   ├── layout/                 <-- XML Layouts
│   │   │   │   ├── drawable/               <-- Images
│   │   │   │   └── values/                 <-- Colors, strings, dimensions, etc.
│   │   │   ├── AndroidManifest.xml         <-- App Definitions
│   │   ├── build.gradle                    <-- Project Dependencies and Configurations
│
└── build.gradle                            <-- Top-level Dependencies
    </code></pre>

    <h2>How to Run the Project</h2>
    <h3>Via Emulator:</h3>
    <p>Set up the emulator and start the project by clicking the Play icon in Android Studio.</p>
    <h3>Via Physical Device:</h3>
    <p>Connect your mobile via USB, enable debugging, and select the device to run the project.</p>

    <h2>Questions and Contributions</h2>
    <p>If you find any issues or have suggestions to improve the project, feel free to open an issue or submit a pull request.</p>

    <h2>Project Display</h2>
    <p>Below are images of the project running:</p>
    <div>
        <h3>Image 1</h3>
        <img src="path/to/image1.jpg" alt="Image 1 of the project">
    </div>
    <div>
        <h3>Image 2</h3>
        <img src="path/to/image2.jpg" alt="Image 2 of the project">
    </div>
</body>
</html>
