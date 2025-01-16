# Define the output folder for the JSON files
$outputFolder = './generated_blockstates'
if (!(Test-Path $outputFolder)) {
    New-Item -ItemType Directory -Path $outputFolder | Out-Null
}

# List of block names
$blocks = @(
    'shattered_dungeon_brick',
    'dungeon_water_still',
    'dungeon_water_overlay',
    'dungeon_water_flow',
    'dungeon_leaves',
    'dungeon_lamp',
    'dungeon_brick2',
    'dungeon_brick',
    'dungeon_bottom'
)

# Template for the blockstate JSON
$template = @'
{
  "variants": {
    "": {
      "model": "soul_morphing:block/{block_name}"
    }
  }
}
'@

# Generate JSON files for each block
foreach ($block in $blocks) {
    $jsonContent = $template -replace '{block_name}', $block
    $filePath = Join-Path -Path $outputFolder -ChildPath "$block.json"
    $jsonContent | Out-File -FilePath $filePath -Encoding UTF8
}

Write-Host "Blockstate JSON files have been generated in the '$outputFolder' folder."
